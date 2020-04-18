package com.kingsoft.jdk8.Test8_Optional;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName OptionalTest2
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 12:18
 * @Version 1.0
 **/
public class OptionalTest2 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("zhangsan");
        employee1.setName("zhangsan");

        Employee employee2 = new Employee("lisi");
        employee2.setName("lisi");

        Company company = new Company();
        company.setName("company");

        List<Employee> employees = Arrays.asList(employee1, employee2);
//        company.setEmployees(employees);

        Optional<Company> optional = Optional.ofNullable(company);

        System.out.println(optional.map(theCompany -> theCompany.getEmployees()).orElse(Collections.emptyList()));

    }


}
