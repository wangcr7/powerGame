package jvm;



/**
 * @program: Real_Madrid_2020
 * @description: 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 * @author: wang chi
 * @create: 2020-06-03 13:36
 */
public class NotInitialization_003 {

    public static void main(String[] args) {

//        System.out.println(ConstClass_003.HELLOWORLD);
        System.out.println(1 - 0.9);
    }
}
