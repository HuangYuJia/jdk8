package com.kingsoft.jdk8.Test11_Stream;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:37
 * @Version 1.0
 **/

public class StreamTest11 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");
        List<String[]> result = list.stream().map(item -> item.split(" ")).distinct()
                .collect(Collectors.toList());
        // [[Ljava.lang.String;@378bf509, [Ljava.lang.String;@5fd0d5ae, [Ljava.lang.String;@2d98a335, [Ljava.lang.String;@16b98e56]
        System.out.println(result);
        result.forEach(item -> Arrays.asList(item).forEach(System.out::println));

        // Stream<String[]> -> Stream<String>
        List<String> list1 = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");
        List<String> result1 = list1.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList());
        System.out.println(result1);
        result1.forEach(System.out::println);

    }

}


