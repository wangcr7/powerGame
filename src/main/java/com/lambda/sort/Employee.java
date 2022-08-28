package com.lambda.sort;

import java.io.Serializable;

/**
 * @program: CristianoRonaldo
 * @description: 需要对一个这样的雇员列表进行排序，排序规则如下：
 *     1、首先级别最高的排在前面，
 *     2、如果级别相等，那么按工资排序，工资高的排在前面，
 *     3、如果工资相当则按入职年数排序，入职时间最长的排在前面。
 * @author: wang chi
 * @create: 2020-07-13 15:01
 */
public class Employee implements Serializable {

    /**
     * ID
     */
    public int id;
    /**
     * 级别
     */
    public int level;
    /**
     * 工资
     */
    public int salary;
    /**
     * 入职年数
     */
    public int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Employee(int id, int level, int salary, int year) {
        this.id = id;
        this.level = level;
        this.salary = salary;
        this.year = year;
    }

}
