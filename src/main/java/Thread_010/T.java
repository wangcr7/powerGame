package Thread_010;

import ThreadTest.SleepUtils;



/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-21 00:26
 */
public class T {

    synchronized void m1 (){
        System.out.println("m1 start...");
        SleepUtils.second(1);
        System.out.println("m1 end...");
    }

    public static void main(String[] args) {
        new TT().m2();
    }
}

class TT extends T{
    synchronized void m2 (){

        System.out.println("m2 start...");
        SleepUtils.second(1);
        super.m1();
        System.out.println("m2 end...");
    }
}
