package com.lambda.sort;

import java.util.Comparator;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-13 15:03
 */
public class EmpComparator implements Comparator<Employee> {

    /**
     * 1、o1 排在 o2 后面（原数组）
     * 2、返回正数不调整位置，返回负数调整位置
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Employee o1, Employee o2) {

        int cr = 0;
        // 按级别降序排列
        int a = o2.getLevel() - o1.getLevel();
        if (a != 0){
            cr = (a > 0) ? 1 : -1;
        } else {
            // 按薪水降序排列
            a = o2.getSalary() - o1.getSalary();
            if (a != 0){
                cr = (a > 0) ? 1 : -1;
            } else {
                // 按入职年数降序排列
                a = o2.getYear() - o1.getYear();
                if (a != 0){
                    cr = (a > 0) ? 1 : -1;
                }
            }
        }
        return cr;
    }
}
