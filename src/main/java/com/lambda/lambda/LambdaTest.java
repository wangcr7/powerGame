package com.lambda.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-13 17:31
 */
public class LambdaTest {

    public static void main(String[] args) throws Exception {

//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("running1 ...");
//            }
//        };
//        runnable1.run();
//
//        Runnable runnable2 = () -> {
//            System.out.println("running2 ...");
//        };
//        runnable2.run();
//
//        Runnable runnable3 = () -> System.out.println("running3 ...");
//        runnable3.run();


        System.out.println("-------------------");

//        Callable<String> callable1 = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "wangchi1";
//            }
//        };
//        System.out.println(callable1.call());
//
//        Callable callable2 = () -> {
//            return "wangchi2";
//        };
//        System.out.println(callable2.call());
//
//        Callable callable3 = () -> "wangchi3";
//        System.out.println(callable3.call());


        System.out.println("------------------");

//        StudentDao studentDao1 = new StudentDao() {
//            @Override
//            public void insert(Student student) {
//                System.out.println("student :" + student);
//            }
//        };
//
//        StudentDao studentDao2 = (student) -> {
//            System.out.println("student :" + student);
//        };
//
//        StudentDao studentDao3 = (Student student) -> System.out.println("student: " + student);
//
//        studentDao1.insert(new Student());
//        studentDao2.insert(new Student());
//        studentDao3.insert(new Student());

        System.out.println("-----------------------");

//        TeacherDao teacherDao1 = new TeacherDao() {
//            @Override
//            public int get(Teacher teacher) {
//                return 1;
//            }
//        };
//
//        TeacherDao teacherDao2 = (teacher) -> {
//            return 2;
//        };
//
//        TeacherDao teacherDao3 = (Teacher teacher) -> {
//            return 3;
//        };
//
//        TeacherDao teacherDao4 = (teacher) -> 4;
//
//        TeacherDao teacherDao5 = (Teacher teacher) -> 5;
//
//        System.out.println(teacherDao1.get(new Teacher()));
//        System.out.println(teacherDao2.get(new Teacher()));
//        System.out.println(teacherDao3.get(new Teacher()));
//        System.out.println(teacherDao4.get(new Teacher()));
//        System.out.println(teacherDao5.get(new Teacher()));

        System.out.println("------------------------------");


//        /**
//         * 在 Java 中提供了一些函数式接口，用来接受后续传入的逻辑，但是对 输入输出有要求
//         */
//
//        /**
//         * 接受一个参数
//         * 返回一个参数
//         */
//        // 相当于 (str) -> {return str.length();}; 实现了 Function<String, Integer> 这个接口
//        // 在后续使用 Function<String, Integer> 接口的时候，直接执行 (str) -> {return str.length();};
//        Function<String, Integer> fi = (str) -> {return str.length();};
//        System.out.println(fi.apply("aaaaa"));
//
//
//        /**
//         * 返回一个参数
//         */
//        Supplier<String> supplier = () -> {return "wangchi";};
//        Supplier<String> supplier2 = () -> "wangchi";
//        System.out.println(supplier.get());
//        System.out.println(supplier2.get());
//
//
//        /**
//         * 接受一个参数
//         */
//        Consumer consumer = (str) -> {System.out.println(str);};
//        consumer.accept("wangchi2");

        System.out.println("-----------------------------");

//        Runnable runnable1 = () -> {
//            int x = get();
//            System.out.println(x);
//        };
//        runnable1.run();
//
//        Runnable runnable2 = () -> exec();
//        runnable2.run();


        System.out.println("--------------------------");

        /**
         //         * 接受一个参数
         //         */
        Consumer<String> consumer = (str) -> {System.out.println(str);};
        consumer.accept("wangchi2");


        List<String> list = Arrays.asList("a", "b", "c");

        // TODO 为什么 println 可以直接调？因为 out 是返回一个对象，相当于使用了 实例方法引用
        Consumer<String> action = System.out::println;
        // list.forEach 参数是 ：接受一个参数的动作
        // 然后对 list 中的元素就行这个操作
        list.forEach(action);

    }


    static int get (){
        return 1;
    }

    static String find (){
        return "find";
    }

    static void exec (){
        find();
    }
}
