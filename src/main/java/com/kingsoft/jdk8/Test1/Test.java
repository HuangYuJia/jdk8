package com.kingsoft.jdk8.Test1;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/12 22:40
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        TheInterface interface1 = () -> {};
        System.out.println(interface1.getClass().getInterfaces()[0]);

        TheInterface2 interface2 = () -> {};
        System.out.println(interface2.getClass().getInterfaces()[0]);

        new Thread(() -> System.out.println("hello")).start();

        List<String> list = Arrays.asList("this","is", "world");
        list.forEach(item -> System.out.println(item.toUpperCase()));

//        List<String> list2 = new ArrayList<>();
//        list.forEach(item -> list2.add(item.toUpperCase()));
//        list2.forEach(item -> System.out.println(item));

//        list.stream().map(item -> item.toLowerCase()).forEach(item -> System.out.println(item));
//        list.stream().map(String::toUpperCase).forEach(item -> System.out.println(item));
    }
}

