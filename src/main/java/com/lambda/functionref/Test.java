package com.lambda.functionref;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-13 19:36
 */
public class Test {

    public static String put (){
        System.out.println("wangchi1");
        return "wangchi2";
    }
    public  String put1 (){
        return "wangchi2";
    }





    public static void getSize(int size){

        System.out.println(size);
    }
    public void getSize1(int size){

        System.out.println(size);
    }




    public static String toUpperCase(String string){
        return string.toUpperCase();
    }
    public String toUpperCase1(String string){
        return string.toUpperCase();
    }





    public static Integer getLength (String string1, String string2){
        return string1.length() + string2.length();
    }
    public Integer getLength1 (String string1, String string2){
        return string1.length() + string2.length();
    }
}
