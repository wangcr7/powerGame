package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: CristianoRonaldo
 * @description: 映射
 * @author: wang chi
 * @create: 2020-07-14 19:40
 */
public class StreamAPITest2 {

    public static void main(String[] args) {

//        map(Function f) --- 接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素

        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
//        Function<String, String> f = (str) -> str.toUpperCase();
//        Function<String, String> function = String::toUpperCase;
        list.stream().map(String::toUpperCase).forEach(System.out::println);


        System.out.println("------------------------------");

        // 练习：获取员工姓名长度大于 3 的员工姓名
        List<Employee> employees = EmployeeDate.getEmployees();
        employees.stream().map(Employee::getName).filter(e -> e.length() > 3).forEach(System.out::println);
        System.out.println("------------------------------");

        // 练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest2::fromStringToStream);
        streamStream.forEach(e -> e.forEach(System.out::println));
        System.out.println("------------------------------");
//        flatMap(Function f) --- 接受一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest2::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    // 将字符串中的多个字符构成的集合转换为对应的 Stream 实例
    public static Stream<Character> fromStringToStream (String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c:str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
