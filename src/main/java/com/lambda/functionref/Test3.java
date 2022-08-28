package com.lambda.functionref;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: CristianoRonaldo
 * @description: 实例方法引用
 * @author: wang chi
 * @create: 2020-07-13 20:13
 */
public class Test3 {
    public static void main(String[] args) {

        System.out.println(new Test().put1());

        // 一个输出
        Supplier<String> s1 = () -> new Test().put1();
        Supplier<String> s3 = new Test()::put1;


        System.out.println(s1.get());
        System.out.println(s3.get());

        System.out.println("----------------------------");

        // 创建一个唯一的 Test 对象
//
        Test test = new Test();

        // 一个输入
        Consumer<Integer> c1 = (size) -> test.getSize1(size);
        c1.accept(1);

        Consumer<Integer> c2 = test::getSize1;
        c2.accept(2);

        System.out.println("--------------------------");

        // 一个输入，一个输出
        Function<String, String> f1 = (str) -> str.toUpperCase();
        Function<String, String> f2 = (str) -> test.toUpperCase1(str);
        Function<String, String> f3 = new Test()::toUpperCase1;
        Function<String, String> f4 = test::toUpperCase1;
        System.out.println(f1.apply("abc"));
        System.out.println(f2.apply("abc"));
        System.out.println(f3.apply("abc"));
        System.out.println(f4.apply("abc"));

        System.out.println("--------------------------------");

        //两个输入，一个输出
        BiFunction<String, String, Integer> biFunction = test::getLength1;
        System.out.println(biFunction.apply("aaaa", "bbb"));


    }
}
