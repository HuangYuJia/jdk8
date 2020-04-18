package com.kingsoft.jdk8.Test7_BinaryOperator;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @ClassName BinaryOperatorTest
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 11:45
 * @Version 1.0
 **/
public class BinaryOperatorTest {

    public static void main(String[] args) {
        BinaryOperatorTest binaryOperatorTest = new BinaryOperatorTest();
        System.out.println(binaryOperatorTest.compute(1, 2,(a, b) -> a + b));
        System.out.println("------------------华丽丽的分割线------------------");
        System.out.println(binaryOperatorTest.compute(4, 2,(a, b) -> a - b));
        System.out.println("------------------华丽丽的分割线------------------");
        System.out.println(binaryOperatorTest.getShort("hello", "the", (a, b) -> a.length() - b.length()));
        System.out.println("------------------华丽丽的分割线------------------");
        System.out.println(binaryOperatorTest.getShort("zspring", "world", (a, b) -> a.charAt(0) - b.charAt(0)));
    }

    // R apply(T t, U u);
    private Integer compute(Integer a, Integer b, BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a, b);
    }

    private String getShort(String a, String b, Comparator<String> comparator){
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}
