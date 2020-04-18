package com.kingsoft.jdk8.Test11_Stream;

import java.util.stream.IntStream;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:37
 * @Version 1.0
 **/
public class StreamTest2 {

    public static void main(String[] args) {

        int[] intArray = new int[]{5,6,7};
        IntStream.of(intArray).forEach(System.out::println);
        System.out.println("-------华丽丽的分割线--------");

        IntStream.range(3, 8).forEach(System.out::println);
        System.out.println("-------华丽丽的分割线--------");
        // 包含边缘值
        IntStream.rangeClosed(3, 8).forEach(System.out::println);
    }
}
