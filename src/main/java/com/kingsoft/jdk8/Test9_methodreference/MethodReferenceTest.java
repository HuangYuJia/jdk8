package com.kingsoft.jdk8.Test9_methodreference;


import com.kingsoft.jdk8.Test3_Function.FunctionTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName MethodReferenceTest
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 14:41
 * @Version 1.0
 **/
public class MethodReferenceTest {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 40);
        Student student3 = new Student("wangwu", 70);
        Student student4 = new Student("zhaoliu", 90);


        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        // 方式一
        // int compare(T o1, T o2);
        students.sort((studentParam1, studentParam2) -> Student.compareStudentByScore(studentParam1, studentParam2));
        students.forEach(student -> System.out.println(student.getScore()));
        System.out.println("------------------华丽丽的分割线------------------");
        // 方式二 类名::静态方法
        students.sort(Student::compareStudentByScore);
        students.forEach(student -> System.out.println(student.getScore()));
        System.out.println("------------------华丽丽的分割线------------------");
        students.sort((studentParma1, studentParam2) -> Student.compareStudentByName(studentParma1, studentParam2)) ;
        students.forEach(student -> System.out.println(student.getName()));
        System.out.println("------------------华丽丽的分割线------------------");
        students.sort(Student::compareStudentByName);
        students.forEach(student -> System.out.println(student.getName()));
        System.out.println("------------------华丽丽的分割线------------------");
        // 方式三
        StudentComparator studentComparator = new StudentComparator();
        students.sort((studentParma1, studentParam2) -> studentComparator.compareStudentByScore(studentParma1, studentParam2));
        students.forEach(student -> System.out.println(student.getScore()));
        System.out.println("------------------华丽丽的分割线------------------");
        // 方式四 引用名(对象名)::实例方法名
        students.sort(studentComparator::compareStudentByScore);
        students.forEach(student -> System.out.println(student.getScore()));
        System.out.println("------------------华丽丽的分割线------------------");
        students.sort((studentParma1, studentParam2) -> studentComparator.compareStudentByName(studentParma1, studentParam2));
        students.forEach(student -> System.out.println(student.getName()));
        System.out.println("------------------华丽丽的分割线------------------");
        students.sort(studentComparator::compareStudentByName);
        students.forEach(student -> System.out.println(student.getName()));
        System.out.println("------------------华丽丽的分割线------------------");
        // 其实也是传递进去两个参数,第一个参数就是调用方法的对象this,第二个参数就是传递进方法中的student
        students.sort(Student::compareByName);
        students.forEach(student -> System.out.println(student.getName()));
        System.out.println("------------------华丽丽的分割线------------------");
        students.sort(Student::compareByScore);
        students.forEach(student -> System.out.println(student.getScore()));
        System.out.println("------------------华丽丽的分割线------------------");
        List<String> cities = Arrays.asList("beijin","henan","guangdong","jieyang","tianjin");
        Collections.sort(cities, (city1, city2) -> city1.compareToIgnoreCase(city2));  // lambda
        cities.forEach(System.out::println);
        System.out.println("------------------华丽丽的分割线------------------");  // 函数引用
        Collections.sort(cities, String::compareToIgnoreCase);
        cities.forEach(System.out::println);
        System.out.println("------------------华丽丽的分割线------------------");
        MethodReferenceTest methodReferenceTest =new MethodReferenceTest();
        System.out.println(methodReferenceTest.getString(String::new));  // 不需要传递参数并有一个返回值
        System.out.println("------------------华丽丽的分割线------------------");
        System.out.println(methodReferenceTest.getString2("hello", String::new));
    }

    private String getString(Supplier<String> supplier){  //  T get();
        return supplier.get() + "test";
    }

    private String getString2(String str, Function<String, String> function){
        return function.apply(str);  //  R apply(T t);
    }

}
