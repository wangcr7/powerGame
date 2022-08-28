package test_synchronized;

import thread.ThreadTest.SleepUtils;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: WChi_Add_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-24 13:10
 */
public class ReadLockTest {

    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                System.out.println("t3 start...");
            }
        }, "t3").start();

        SleepUtils.second(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                System.out.println("t1 start...");
                while (true){

                }
            }
        }, "t1").start();

        SleepUtils.second(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                System.out.println("t2 start...");

            }
        }, "t2").start();

        SleepUtils.second(2);



    }
}
