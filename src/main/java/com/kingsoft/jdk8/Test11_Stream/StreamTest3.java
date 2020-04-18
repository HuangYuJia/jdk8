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
public class StreamTest3 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println(list.stream().map(i -> 2*i).reduce(0, Integer::sum));  // R apply(T t, U u);
        // 0 + 1*2 + 2*2 + 3*2 + 4*2 + 5*2 + 6*2 = 42
    }
}
