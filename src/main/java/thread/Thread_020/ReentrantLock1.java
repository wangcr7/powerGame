package thread.Thread_020;

import thread.ThreadTest.SleepUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-21 20:25
 */
public class ReentrantLock1 {

    Lock lock = new ReentrantLock();

    void m1 (){
        try {
            lock.lock();
            System.out.println("t1 启动...");
            for (int i = 0; i < 10; i++) {
                SleepUtils.second(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2(){
        lock.lock();
        System.out.println("t2 启动...");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock1 reentrantLock1 = new ReentrantLock1();

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock1.m1();
            }
        }).start();

        SleepUtils.second(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock1.m2();
            }
        }).start();
    }
}
