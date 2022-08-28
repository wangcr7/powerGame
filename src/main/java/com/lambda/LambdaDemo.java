package com.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-06 19:48
 */

@SuppressWarnings("all")
public class LambdaDemo {

    public static void main(String[] args) {

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("running...");
//            }
//        }).start();
//
//        new Thread(() -> {
//            System.out.println("running...");
//        }).start();

        List<String> list = Arrays.asList("java", "javascript", "scala", "python");

//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//
//        for (String str:list) {
//            System.out.println(str);
//        }

        Collections.sort(list, (a, b) -> a.length() - b.length());
        list.forEach(System.out::println);
    }
}
