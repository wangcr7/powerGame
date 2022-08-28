package com.lambda.functionref;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-14 10:59
 */
public class Test5 {

    public static void main(String[] args) {

        Supplier<Person> s1 = () -> new Person();
        s1.get();

        Supplier<Person> s2 = Person::new;
        s2.get();

        Supplier<List> s3 = ArrayList::new;
        Supplier<Set> s4 = HashSet::new;
        Supplier<Thread> s5 = Thread::new;
        Supplier<String> s6 = String::new;
//        Supplier<Integer> s7 = Integer::new;

        Consumer<Integer> c1 = (age) -> new Account(age);
        Consumer<Integer> c2 = Account::new;

        Consumer<Integer> c3 = Integer::new;

//        Stream

    }
}

class Account{

    public Account() {

        System.out.println("调用无参构造...");
    }

    public Account(int age){
        System.out.println("age 参数构造...");
    }

    public Account(String str){
        System.out.println("str 参数构造...");
    }
}
class Person {

    public Person() {

        System.out.println("调用无参构造...");
    }
}
