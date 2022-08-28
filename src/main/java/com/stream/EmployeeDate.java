package com.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-14 15:06
 */
public class EmployeeDate {

    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1001, "马云", 12, 9876.12));
        list.add(new Employee(1001, "刘强东", 33, 3000.82));
        list.add(new Employee(1001, "雷军", 26, 7657.37));
        list.add(new Employee(1001, "李彦宏", 65, 5555.32));
        list.add(new Employee(1001, "比尔盖茨", 42, 9500.43));
        list.add(new Employee(1001, "任正非", 26, 4333.32));
        list.add(new Employee(1001, "扎克伯格", 35, 2500.32));

        return list;
    }
}
