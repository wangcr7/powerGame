package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;



/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-10-28 15:05
 */
public class test {

    public static void main(String[] args) {


        User user1 = new User(1, "张三", 11);
        User user2 = new User(1, "李四", 12);
        User user3 = new User(3, "王五", 13);
        User user4 = new User(4, "赵六", 14);
        User user5 = new User(5, "七七", 15);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        List<User> unique1 = list.stream().filter(distinctByKey(b->b.getId())).collect(Collectors.toList());

        for (int i = 0; i < unique1.size(); i++) {
            System.out.println(unique1.get(i).toString() + "&");
        }
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


}
