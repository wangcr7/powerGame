package com.lambda.why4;

import com.lambda.why.Student;
import com.lambda.why2.StudentFilter;

import java.util.ArrayList;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-13 16:49
 */
public class Test {

    public static void main(String[] args) {


        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("zhangsan", 14, 67));
        list.add(new Student("lisi", 13, 89));
        list.add(new Student("wangwu", 15, 97));
        list.add(new Student("maliu", 12, 63));
        list.add(new Student("zhaoqi", 17, 75));


        // 相当于 (e) -> e.getAge() > 14 实现了 StudentFilter 这个接口
        // 在后续使用 StudentFilter studentFilter 的时候，直接执行 (e) -> e.getAge() > 14;
        StudentFilter studentFilter = (e) -> e.getAge() > 14;
        getByFilter(list, studentFilter);
//        getByFilter(list, (e) -> e.getScore() > 75);


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
