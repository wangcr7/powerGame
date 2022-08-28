package com.lambda.why2;

import com.lambda.why.Student;

import java.util.ArrayList;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-13 16:37
 */
public class Test {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("zhangsan", 14, 67));
        list.add(new Student("lisi", 13, 89));
        list.add(new Student("wangwu", 15, 97));
        list.add(new Student("maliu", 12, 63));
        list.add(new Student("zhaoqi", 17, 75));

        getByFilter(list, new AgeFilter());

        System.out.println("-----------------------");
        getByFilter(list, new ScoreFilter());

    }

    public static void getByFilter(ArrayList<Student> students, StudentFilter studentFilter){
        ArrayList<Student> list = new ArrayList<>();

        for (Student student:students) {
            if (studentFilter.compare(student)){
                list.add(student);
            }
        }

        for (Student student : list){
            System.out.println(student);
        }

    }
}
