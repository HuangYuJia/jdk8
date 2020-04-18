package com.kingsoft.jdk8.Test11_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:37
 * @Version 1.0
 **/
public class StreamTest1 {

    public static void main(String[] args) {

        // 方式一:
        Stream stream1 = Stream.of("hello", "world", "hello world");

        // 方式二:
        String[] myArray = new String[]{"hello", "world", "hello world"};
        Stream stream2 = Stream.of(myArray);

        // 方式三:
        Stream stream3 = Arrays.stream(myArray);

        // 方式四:
        List<String> list = Arrays.asList(myArray);
        Stream stream4 = list.stream();

    }
}
