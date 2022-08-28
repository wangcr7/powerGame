package test_synchronized;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *https://www.cnblogs.com/takumicx/p/9402021.html#2abstractqueuedsynchronizer%E4%BB%8B%E7%BB%8D
 */

/**
 * @program: TestJava
 * @description: 源码分析
 * @author: wang chi
 * @create: 2020-05-10 23:54
 */
public class ReentrantLockExample {

    int a = 0;
    ReentrantLock lock = new ReentrantLock(true);

    Condition condition = lock.newCondition();

    public void writer(){
        lock.lock();
        try {
            a++;
        } finally {
            lock.unlock();
        }
    }

    public void reader(){
        lock.lock();
        try {
            int i = a;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();

//        reentrantLockExample.writer();
//
//        reentrantLockExample.reader();


        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLockExample.writer();
            }
        }).start();

        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLockExample.reader();
            }
        }).start();


        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLockExample.writer();
            }
        }).start();

        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLockExample.reader();
            }
        }).start();
    }
}
