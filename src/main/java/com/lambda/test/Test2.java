package com.lambda.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-02 14:20
 */
public class Test2 {

    public static String put (){
        System.out.println("wangchi1");
        return "wangchi2";
    }

    public static String toUpper (String str){
        return str.toUpperCase();
    }


    public static void main(String[] args) {

        Supplier s1 = Test2::put;
        System.out.println(s1.get());

        Function<String,String> f2 = (str) -> Test2.toUpper(str);
        Function<String,String> f3 = Test2::toUpper;

        List arr = Arrays.asList("aa","bb","cc","dd");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n -> System.out.println(n));

    }
}
