package com.kingsoft.jdk8.Test6_Supplier;

import java.util.function.Supplier;

/**
 * @ClassName SupplierTest
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 11:27
 * @Version 1.0
 **/
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello";
        System.out.println(supplier.get());
        System.out.println("------------------华丽丽的分割线------------------");
        Supplier<Student> supplier1 = () -> new Student();
        System.out.println(supplier1.get().getName());
        System.out.println("------------------华丽丽的分割线------------------");
        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());
        System.out.println("------------------华丽丽的分割线------------------");
    }
}
