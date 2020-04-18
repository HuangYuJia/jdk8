package com.kingsoft.jdk8.Test8_Optional;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 14:15
 * @Version 1.0
 **/
public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
