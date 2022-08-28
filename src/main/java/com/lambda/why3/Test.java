package com.lambda.why3;

import com.lambda.why.Student;
import com.lambda.why2.StudentFilter;

import java.util.ArrayList;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-13 16:43
 */
public class Test {

    public static void main(String[] args) {


        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("zhangsan", 14, 67));
        list.add(new Student("lisi", 13, 89));
        list.add(new Student("wangwu", 15, 97));
        list.add(new Student("maliu", 12, 63));
        list.add(new Student("zhaoqi", 17, 75));

        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getAge() > 14;
            }
        });

        System.out.println("--------------------");

        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getScore() > 75;
            }
        });

        System.out.println("----------------");
        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getName().length() > 5;
            }
        });

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
