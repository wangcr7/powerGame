package com.optional;

import java.util.Optional;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-15 23:17
 */
public class OptionalTest {



    public static String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    public static void main(String[] args) {

        Girl girl = new Girl();
        girl = null;
//        Optional<Girl> optionalGirl = Optional.of(girl);
        boolean f = Optional.ofNullable(girl).isPresent();
        System.out.println(f);

        System.out.println("------------------------------");

//        Boy boy = new Boy();
//        String girlName = getGirlName(boy);
//        System.out.println(girlName);

    }
}
