package com.kingsoft.jdk8.Test8_Optional;

import java.util.List;

/**
 * @ClassName Company
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 14:26
 * @Version 1.0
 **/
public class Company {

    private String name;
    private List<Employee> employees;

    public Company(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public Company() {
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company(String name) {
        this.name = name;
    }

}
