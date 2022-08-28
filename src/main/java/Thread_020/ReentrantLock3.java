package Thread_020;

import ThreadTest.SleepUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-21 22:28
 */
public class ReentrantLock3 {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("t1 start...");
                    SleepUtils.second(Integer.MAX_VALUE);
                    System.out.println("t1 end...");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "t1");
        t1.start();

        SleepUtils.second(5);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //lock.lock();
                    lock.lockInterruptibly();
                    System.out.println("t2 start...");
                    SleepUtils.second(1);
                    System.out.println("t2 end...");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "t2");
        t2.start();
        SleepUtils.second(2);
        t2.interrupt();
    }
}
