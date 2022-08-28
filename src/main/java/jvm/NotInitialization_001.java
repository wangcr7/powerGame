package jvm;



/**
 * @program: Real_Madrid_2020
 * @description: 通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化
 * @author: wang chi
 * @create: 2020-06-03 13:27
 */
public class NotInitialization_001 {

    public static void main(String[] args) {

//        SubClass_001 class_001 = new SubClass_001();
        System.out.println(SubClass_001.value);
    }


}
