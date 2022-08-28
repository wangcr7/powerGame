package com.lambda.functionref;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-13 19:29
 */
public class Test1 {
    public static void main(String[] args) {

        /**
         * 接受一个参数
         * 返回一个参数
         */
        // 相当于 (str) -> {return str.length();}; 实现了 Function<String, Integer> 这个接口
        // 在后续使用 Function<String, Integer> 接口的时候，直接执行 (str) -> {return str.length();};
        Function<String, Integer> fi = (str) -> {return str.length();};
        System.out.println(fi.apply("aaaaa"));

        /**
         * 接受一个参数
         */
        Consumer consumer = (str) -> {System.out.println(str);};
        consumer.accept("wangchi2");


    }
}
