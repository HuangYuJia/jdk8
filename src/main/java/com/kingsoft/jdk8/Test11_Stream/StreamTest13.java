package com.kingsoft.jdk8.Test11_Stream;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:37
 * @Version 1.0
 **/

public class StreamTest13 {

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        // 分组
        // Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
        // Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getScore));
        // Map<String, Long> map = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        // Map<String, Double> map = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        // 分区 分为一个true区一个false区
        Map<Boolean, List<Student>> map = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        System.out.println(map);
    }

}


class Student {

    private String name;
    private int score;
    private int age;

    public Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
    }
}
