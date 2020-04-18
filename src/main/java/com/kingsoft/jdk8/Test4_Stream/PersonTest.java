package com.kingsoft.jdk8.Test4_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @ClassName PersonTest
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 10:21
 * @Version 1.0
 **/
public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 10);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 22);

        List<Person> persons = Arrays.asList(person1, person2, person3);

        PersonTest personTest = new PersonTest();

        // test1
        List<Person> personResult = personTest.getPersonByUsername("zhangsan", persons);
        personResult.forEach(person -> System.out.println(person.getName()));
        System.out.println("----------华丽丽的分割线-----------------------");

        // test2
        List<Person> personResult1 = personTest.getPersonByAge(20, persons);
        personResult1.forEach(person -> System.out.println(person.getAge()));
        System.out.println("----------华丽丽的分割线-----------------------");

        // test3
        List<Person> personResult2 = personTest.getPersonByAge2(20, persons,(age, personList) -> {
            return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
        });
        personResult2.forEach(person -> System.out.println(person.getAge()));
        System.out.println("----------华丽丽的分割线-----------------------");

        // test4
        List<Person> personResult3 = personTest.getPersonByAge2(20, persons,(age, personList) -> {
            return personList.stream().filter(person -> person.getAge() <= age).collect(Collectors.toList());
        });
        personResult3.forEach(person -> System.out.println(person.getAge()));
    }

    private List<Person> getPersonByUsername(String username, List<Person> persons) {
        return persons.stream().filter(person -> person.getName().equals(username)).collect(Collectors.toList());
    }

    //  R apply(T t, U u);
    private List<Person> getPersonByAge(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) -> {
            return personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
        };
        return biFunction.apply(age, persons);
    }

    private List<Person> getPersonByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, persons);
    }

}
