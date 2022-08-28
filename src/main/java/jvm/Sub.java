package jvm;



/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-04 20:37
 */
public class Sub extends Parent{

    static {
        System.out.println("Sub static...");
    }

    public Sub(){
        System.out.println("Sub init...");
    }

    public static void main(String[] args) {

        Sub sub = new Sub();
    }
}
