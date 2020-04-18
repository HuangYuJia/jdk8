package com.kingsoft.jdk8.Test10_defaultmethod;

/**
 * @ClassName MyClassTest
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:21
 * @Version 1.0
 **/

// 实现类的优先级要比接口的优先级更高一些.
public class MyClassTest_2 extends MyInterface1Impl implements MyInterface2{

    public static void main(String[] args) {
        MyClassTest_2 myClass = new MyClassTest_2();
        myClass.myMethod();  // MyInterface1Impl
    }
    
}
