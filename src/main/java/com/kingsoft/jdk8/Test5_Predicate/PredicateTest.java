package com.kingsoft.jdk8.Test5_Predicate;

import com.kingsoft.jdk8.Test4_Stream.PersonTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName PredicateTest
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 10:48
 * @Version 1.0
 **/
public class PredicateTest {

    public static void main(String[] args) {
        // boolean test(T t);
        Predicate<String> predicate = p -> p.length() > 5;
        System.out.println(predicate.test("helloworld"));
        System.out.println("----------华丽丽的分割线-----------------------");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        PredicateTest predicateTest = new PredicateTest();
        predicateTest.conditionFilter(list, item -> item % 2 == 0);
        System.out.println("----------华丽丽的分割线-----------------------");
        predicateTest.conditionFilter(list, item -> item % 2 != 0);
        System.out.println("----------华丽丽的分割线-----------------------");
        predicateTest.conditionFilter(list, item -> item > 5);
        System.out.println("----------华丽丽的分割线-----------------------");
        predicateTest.conditionFilter(list, item -> item < 5);
        System.out.println("----------华丽丽的分割线-----------------------");
        predicateTest.conditionFilter(list, item -> true);
        System.out.println("----------华丽丽的分割线-----------------------");
        predicateTest.conditionFilter2(list, item -> item > 5, item -> item % 2 == 0);
        System.out.println("----------华丽丽的分割线-----------------------");
        boolean result = predicateTest.isEqual("test").test("test");
        System.out.println(result);
    }

    private Predicate<String> isEqual(Object object){
        return Predicate.isEqual(object);
    }

    private void conditionFilter2(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2){
        for (Integer integer: list){
            //  (item -> item > 5 and item -> item % 2 == 0)  ===>> 6 8
            if(predicate.and(predicate2).negate().test(integer)){
                System.out.println(integer);
            }
        }
    }

    private void conditionFilter(List<Integer> list, Predicate<Integer> predicate){
        for (Integer integer: list){
            if(predicate.test(integer)){
                System.out.println(integer);
            }
        }
    }

}
