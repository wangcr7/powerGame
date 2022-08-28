package com.lambda.functionref;

import java.util.function.Consumer;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-14 10:21
 */
public class Test4 {

    public static void main(String[] args) {

        Consumer<Too> c1 = (Too too) -> too.foo();
        c1.accept(new Too());

        // 抽象方法的第一个参数类型刚好是 实例方法的所在的类的类型，抽象方法剩余的参数 恰好可以当做实例方法的参数，
        // 如果函数式接口的实现能由上面说的实例方法调用来实现的话，那么就可以使用对象方法引用

        // 抽象方法剩余的参数是 空
        Consumer<Too> c3 = Too::foo;
        c3.accept(new Too());

        // 抽象方法的第一个参数类型刚好是 实例方法的所在的类的类型，抽象方法剩余的参数 恰好可以当做实例方法的参数，
        // 如果函数式接口的实现能由上面说的实例方法调用来实现的话，那么就可以使用对象方法引用

        // 抽象方法剩余的参数是 String
//        BiConsumer<Too2, String> bc = ((too2, s) -> new Too2().show(s));
//        BiConsumer<Too2, String> bc2 = Too2::show;
//
//        // 抽象方法
//        bc.accept(new Too2(), "abc");
//        // 抽象方法
//        bc2.accept(new Too2(), "wangchi");
//
//        BiFunction<Exec, String, Integer> bf1 = (e, s) -> new Exec().test(s);
//        bf1.apply(new Exec(), "abc");
//
//        BiFunction<Exec, String, Integer> bf2 = Exec::test;
//        bf2.apply(new Exec(), "def");

    }
}

class Exec{

    public int test(String name){

        return 1;
    }
}

class Too{
    public Integer fun(String s){
        return 1;
    }

    public void foo(){
        System.out.println("foo");
    }
}

class Too2{
    public Integer fun(String s){
        return 1;
    }

    public void foo(){
        System.out.println("foo---too2");
    }

    public void show(String s){

        System.out.println(s);
    }
}
