package com.kingsoft.jdk8.Test11_Stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:37
 * @Version 1.0
 **/

public class StreamTest5 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------------");
        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        list2.stream().map(item -> item * item).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------------");
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1), Arrays.asList(2,3), Arrays.asList(4,5,6));
        stream.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------------");
    }

}
