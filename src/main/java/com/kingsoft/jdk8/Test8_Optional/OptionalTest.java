package com.kingsoft.jdk8.Test8_Optional;

import java.util.Optional;

/**
 * @ClassName OptionalTest
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 12:11
 * @Version 1.0
 **/
public class OptionalTest {

    public static void main(String[] args) {

//        Optional<String> optional = Optional.of("hello");
        Optional<String> optional = Optional.empty();

        // 老的方式,和直接判断没区别
//        if(optional.isPresent()){
//            System.out.println(optional.get());
//        }

        optional.ifPresent(System.out::println);  // 推荐的Optional使用方式
        System.out.println("-------------------------");
        System.out.println(optional.orElse("world"));
        System.out.println("-------------------------");
        System.out.println(optional.orElseGet(() -> "hello"));
    }
}
