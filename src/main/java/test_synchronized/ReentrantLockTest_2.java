package test_synchronized;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: TestJava
 * @description: 实现公平锁
 * @author: wang chi
 * @create: 2020-05-11 11:27
 */
public class ReentrantLockTest_2 {

    static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {

        for (int i = 0;i<5;i++){

            new Thread(new ThreadDemo(i)).start();
        }
    }

    static class ThreadDemo implements Runnable{
        Integer id;
        public ThreadDemo(Integer _id){
            id = _id;
        }
        @Override
        public void run() {

            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0;i<3;i++){
                try {
                    lock.lock();
                    System.out.println("获得锁的线程：" + id);
                } finally {
                    lock.unlock();
                }

            }
        }
    }
}
