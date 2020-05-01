package com.kingsoft.jdk8.Test11_Stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:37
 * @Version 1.0
 **/

public class StreamTest12 {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("乔丹", "麦迪", "艾弗森");
        List<String> list2 = Arrays.asList("MVP", "FMVP", "VIP");
        List<String> result = list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).
                collect(Collectors.toList());
        result.forEach(System.out::println);

    }

}


