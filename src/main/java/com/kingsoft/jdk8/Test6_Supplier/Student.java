package com.kingsoft.jdk8.Test6_Supplier;

/**
 * @ClassName Student
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 11:29
 * @Version 1.0
 **/
public class Student {

    private String name = "zhangsan";
    private Integer age = 20;

    public Student(){

    }

    public Student(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
