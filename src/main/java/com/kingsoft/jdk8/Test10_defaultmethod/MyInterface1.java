package com.kingsoft.jdk8.Test10_defaultmethod;

/**
 * @ClassName MyInterface2
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:20
 * @Version 1.0
 **/
public interface MyInterface1 {

    default void myMethod() {
        System.out.println("MyInterface1");
    }

}
