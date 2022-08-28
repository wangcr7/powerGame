package com.stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @program: CristianoRonaldo
 * @description: 筛选 与 切片
 * @author: wang chi
 * @create: 2020-07-14 15:04
 */
public class StreamAPITest1 {

    public static void main(String[] args) {

        List<Employee> list = EmployeeDate.getEmployees();

//        filter(Predicate p) --- 接受lambda，从流中排除某些元素
        list.stream().filter(new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 7000;
            }
        }).forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                System.out.println(employee.toString());
            }
        });

        System.out.println("--------------------------");

        list.stream().filter(e -> e.getSalary() > 7000).forEach(System.out::println);

//        limit(n) --- 截断流，使其元素不超过给定数量
        System.out.println("--------------------------");
        list.stream().limit(3).forEach(System.out::println);
//        skip(n) --- 跳过前面几个元素，返回一个扔掉了前 n 个元素的流，若流中元素不足 n 个，则返回一个空流，与 limit(n) 互补
        System.out.println("--------------------------");
        list.stream().skip(3).forEach(System.out::println);
//        distinct() --- 筛选，通过流所生成元素的 hashcode() 和 equals() 去除重复元素
        System.out.println("--------------------------");
        list.add(new Employee(1010, "刘强东", 40, 8000.00));
        list.add(new Employee(1010, "刘强东", 40, 8000.00));
        list.add(new Employee(1010, "刘强东", 40, 8000.00));
        list.add(new Employee(1010, "刘强东", 40, 8000.00));
        list.stream().distinct().forEach(System.out::println);

    }

}
