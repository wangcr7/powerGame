package com.lambda.test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-02 14:19
 */
public class Test {

    public static void main(String[] args) {


        /**
         * 接受一个参数
         * 返回一个参数
         */
        // 相当于 (str) -> {return str.length();}; 实现了 Function<String, Integer> 这个接口
        // 在后续使用 Function<String, Integer> 接口的时候，直接执行 (str) -> {return str.length();};
        Function<String, Integer> fi = (str) -> {return str.length();};
        System.out.println(fi.apply("aaaaa"));


//        List

        /**
         * 返回一个参数
         */
        Supplier<String> supplier = () -> {return "wangchi";};
        System.out.println(supplier.get());


        /**
         * 接受一个参数
         */
        Consumer consumer = (str) -> {System.out.println(str);};
        consumer.accept("wangchi2");

//        Stream


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("running...");
            }
        };
        runnable1.run();


        Runnable runnable2 = () -> {
            System.out.println("running2");
        };
        runnable2.run();

        //相当于  () -> System.out.println("running3"); 实现了 Runnable 接口，
        // 在后续使用 Runnable 的时候，直接 执行 System.out.println("running3")
        Runnable runnable3 = () -> System.out.println("running3");
        runnable3.run();

        System.out.println("-------------------");

        Runnable runnable4 = () -> {
            System.out.println(get());
        };
        runnable4.run();

        Runnable runnable5 = () -> {
            exec();
        };


        BiFunction<String, String, Integer> bi = (a, b) -> a.length() + b.length();
        System.out.println(bi.apply("aaaaa", "b"));



    }


    static int get(){
        return 1;
    }

    static String find(){
        return "wangchi";
    }

    static void exec(){
        find();
    }
}
