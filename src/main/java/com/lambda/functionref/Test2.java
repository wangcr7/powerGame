package com.lambda.functionref;

import java.util.function.*;

/**
 * @program: CristianoRonaldo
 * @description: 静态方法引用
 * @author: wang chi
 * @create: 2020-07-13 19:30
 */
public class Test2 {

    static String put (){
        System.out.println("put ...");
        return "put";
    }

    public static void main(String[] args) {

        System.out.println(put());

        System.out.println("---------------------");

        Supplier<String> s1 = ()-> Test.put();
        System.out.println(s1.get());

        Supplier<String> s2 = Test::put;
        System.out.println(s2.get());

        System.out.println("------------------------");

        Consumer<Integer> c1 = Test::getSize;

        // 抽象方法的第一个参数类型刚好是 实例方法的所在的类的类型，抽象方法剩余的参数 恰好可以当做实例方法的参数，
        // 如果函数式接口的实现能由上面说的实例方法调用来实现的话，那么就可以使用对象方法引用
        BiConsumer<Test, Integer> c3 = Test::getSize1;
        // 抽象方法
        c3.accept(new Test(), 1);

        Consumer<Integer> c2 = (size) -> Test.getSize(size);
        c1.accept(1234);
        c2.accept(12345);

        System.out.println("------------------------");

        Function<String, String> f1 = (str) -> str.toUpperCase();
        Function<String, String> f2 = (str) -> Test.toUpperCase(str);
        Function<String, String> f3 = Test::toUpperCase;

        System.out.println(f1.apply("abc"));
        System.out.println(f2.apply("abc"));
        System.out.println(f3.apply("abc"));

        System.out.println("------------------------");

        BiFunction<String, String, Integer> bf = (a,b) -> a.length() + b.length();
        BiFunction<String, String, Integer> bf2 = Test::getLength;
        System.out.println(bf2.apply("abc", "hui"));


    }
}
