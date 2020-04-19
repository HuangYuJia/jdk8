package com.kingsoft.jdk8.Test11_Stream;


import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:37
 * @Version 1.0
 **/

public class StreamTest10 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().mapToInt(item -> item.length()).filter(length -> length == 5)
                .findFirst().ifPresent(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------------");
        // 流的特征:流的短路,和&& || 一样,遇到满足的条件就不往后执行了
        List<String> list1 = Arrays.asList("hello", "world", "hello world");
        list1.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------------");
        List<String> list2 = Arrays.asList("hello1", "world", "hello world");
        list2.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------------");
        List<String> list3 = Arrays.asList("hello1", "world1", "hello world", "bobby");
        list3.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
    }
}


