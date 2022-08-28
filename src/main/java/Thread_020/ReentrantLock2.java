package Thread_020;

import ThreadTest.SleepUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-21 22:17
 */
public class ReentrantLock2 {

    Lock lock = new ReentrantLock();

    void m1(){
        try {
            lock.lock();
            for (int i = 0;i<10;i++){
                while (true){
                SleepUtils.second(1);
                System.out.println(i);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2(){
//        boolean flag = lock.tryLock();
//        if (!flag){
//            System.out.println("没获取锁...");
//        } else {
//            try {
//                System.out.println("获取到锁了...");
//            } finally {
//                lock.unlock();
//            }
//        }

        try {
            boolean flag = lock.tryLock(5, TimeUnit.SECONDS);
            if (!flag){
                System.out.println("没拿到锁...");
            }else {
                try {
                    System.out.println("拿到锁了...");
                } finally {
                    lock.unlock();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void main(String[] args) {

        ReentrantLock2 reentrantLock2 = new ReentrantLock2();

        new Thread(reentrantLock2::m1).start();

        SleepUtils.second(1);

        Thread t = new Thread(reentrantLock2::m2);
        t.start();

        SleepUtils.second(1);

        t.interrupt();
    }
}
