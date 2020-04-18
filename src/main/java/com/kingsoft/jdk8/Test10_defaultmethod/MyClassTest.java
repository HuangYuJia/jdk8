package com.kingsoft.jdk8.Test10_defaultmethod;

/**
 * @ClassName MyClassTest
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:21
 * @Version 1.0
 **/
public class MyClassTest implements MyInterface1, MyInterface2{

    @Override
    public void myMethod() {
        MyInterface2.super.myMethod();
    }

    public static void main(String[] args) {
        MyClassTest myClass = new MyClassTest();
        myClass.myMethod();  // MyInterface2
    }

}
