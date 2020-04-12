package com.kingsoft.jdk8.Test3_Function;

import java.util.function.Function;

/**
 * @ClassName FunctionTest
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/12 23:12
 * @Version 1.0
 **/
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        System.out.println(test.compute(1, value -> {return 2 * value;}));
        System.out.println(test.compute(2, value -> 5 * value));
        System.out.println(test.compute(3, value -> value * value));
        System.out.println(test.convert(4, value -> String.valueOf(value + "helloworld")));

        Function<Integer, Integer> function = value -> value * 2;
        System.out.println(test.compute(4, function));
    }


    private int compute(int i, Function<Integer, Integer> function){
        int result = function.apply(i);
        return result;
    }

    private String convert(int a, Function<Integer, String> function){
        return function.apply(a);
    }
}
