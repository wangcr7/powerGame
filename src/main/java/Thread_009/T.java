package Thread_009;


import ThreadTest.SleepUtils;

/**
 * @program: TestJava
 * @description: 可重入锁：一个同步方法可以调用另外一个同步方法，一个线程已经拥有了某个对象的锁，再次申请的时候仍然会得到这个对象的锁
 * @author: wang chi
 * @create: 2020-05-21 00:16
 */
public class T {

    synchronized void m1 (){
        System.out.println("m1 start...");
        SleepUtils.second(1);
        m2();
    }
    synchronized void m2 (){
        SleepUtils.second(1);
        System.out.println("m2 start...");
    }
}
