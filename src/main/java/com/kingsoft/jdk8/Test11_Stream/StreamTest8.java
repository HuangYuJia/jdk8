package com.kingsoft.jdk8.Test11_Stream;


import java.util.stream.IntStream;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:37
 * @Version 1.0
 **/

public class StreamTest8 {

    public static void main(String[] args) {
        // iterate会死循环,必须先limit再distinct
        // IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
    }
}


