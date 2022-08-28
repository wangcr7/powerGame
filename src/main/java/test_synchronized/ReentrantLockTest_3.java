package test_synchronized;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: TestJava
 * @description: 响应中断的例子
 * @author: wang chi
 * @create: 2020-05-11 11:48
 */
public class ReentrantLockTest_3 {

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new ThreadDemo(lock1, lock2));
        Thread thread2 = new Thread(new ThreadDemo(lock2, lock1));

        thread1.setName("线程1");
        thread2.setName("线程2");

        thread1.start();
        thread2.start();

        thread1.interrupt();
    }

    static class ThreadDemo implements Runnable{

        Lock fristLock;
        Lock seconeLock;

        public ThreadDemo(Lock _fristLock, Lock _seconeLock) {
            this.fristLock = _fristLock;
            this.seconeLock = _seconeLock;
        }

        @Override
        public void run() {

            try {
                fristLock.lock();
                TimeUnit.MILLISECONDS.sleep(10);
                seconeLock.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                fristLock.unlock();
                seconeLock.unlock();
                System.out.println(Thread.currentThread().getName() + "正常结束");
            }

        }
    }
}
