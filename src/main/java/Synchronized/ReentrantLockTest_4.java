package Synchronized;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: TestJava
 * @description: 结合 condition 实现等待通知机制/子线程通知主线程
 * @author: wang chi
 * @create: 2020-05-11 12:48
 */
public class ReentrantLockTest_4 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        lock.lock();

        new Thread(new SignalThread()).start();

        System.out.println("主线程等待通知");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


        System.out.println("主线程恢复运行");
    }

    static class SignalThread implements Runnable{

        @Override
        public void run() {
            lock.lock();
            try {
                condition.signal();
                System.out.println("子线程通知");
            } finally {
                lock.unlock();
            }
        }
    }
}
