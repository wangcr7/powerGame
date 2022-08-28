package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-14 11:32
 */

@SuppressWarnings("all")
public class StreamDemo {

    // 通过数组生成
    static void gen1 (){
        String[] strings = {"a", "b", "c", "d"};

        Stream<String> stream = Stream.of(strings);
        stream.forEach(System.out::println);
    }

    //通过集合来生成
    static void gen2 (){
        List<String> list = Arrays.asList("1", "2", "3", "4");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    // generate 生成
    static void gen3(){

        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(10).forEach(System.out::println);
    }

    static void gen4(){
        Stream<Integer> iterate = Stream.iterate(2, (x) -> x + 2);
        iterate.limit(10).forEach(System.out::println);
    }

    static void gen5(){
        String str = "abcdefg";
        IntStream stream = str.chars();
        stream.forEach(System.out::println);
    }


    public static void main(String[] args) {

//        gen1();
//        gen2();
//        gen3();
//        gen4();
//        gen5();

        // 如果调用方法之后返回的结果是 Stream 对象，就意味着是 中间操作
        Arrays.asList(1, 2, 3, 4, 5).stream().filter((x) -> x%2 == 0).forEach(System.out::print);
        System.out.println();
        // 求集合中所有偶数只和
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().filter((x) -> x % 2 == 0).mapToInt(x -> x).sum());
        // 求集合项中的最大值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 4, 6);
        Optional<Integer> max = list.stream().max((a, b) -> a - b);
        System.out.println(max.get());
        // 求集合项中的最小值
        Optional<Integer> min = list.stream().min((a, b) -> a - b);
        System.out.println(min.get());


        System.out.println(list.stream().filter(x -> x % 2 == 0).findAny().get());


    }
}
