package com.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @program: CristianoRonaldo
 * @description: 排序
 * @author: wang chi
 * @create: 2020-07-15 01:11
 */
public class StreamAPITest3 {

    public static void main(String[] args) {

        // sorted() --- 自然排序

        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -45, 8);
        list.stream().sorted().forEach(System.out::println);

        // 抛异常，原因是 Employee 没有 实现 Comparable 接口
        List<Employee> employees = EmployeeDate.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);
        // sorted(Comparator com) --- 定制排序

//        Predicate



        employees.stream().sorted( (e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .forEach(System.out::println);


    }
}
