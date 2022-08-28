package com.lambda.why;

import java.util.ArrayList;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-13 15:54
 */
public class Test {

    public static void main(String[] args) {


        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("zhangsan", 14, 67));
        list.add(new Student("lisi", 13, 89));
        list.add(new Student("wangwu", 15, 97));
        list.add(new Student("maliu", 12, 63));
        list.add(new Student("zhaoqi", 17, 75));

        // 查找年龄大于 14 的学生
        findByAge(list);
        System.out.println("---------------------");
        // 查找分数大于 75 的学生
        findByScore(list);
    }

    public static void findByAge (ArrayList<Student> students){
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : students){
            if (student.getAge() > 14){
                list.add(student);
            }
        }
        for (Student student : list){
            System.out.println(student);
        }
    }

    public static void findByScore (ArrayList<Student> students){
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : students){
            if (student.getScore() > 75){
                list.add(student);
            }
        }
        for (Student student : list){
            System.out.println(student);
        }
    }
}
