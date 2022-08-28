package ThreadTest;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-20 14:33
 */
public class Interrupted {



    public static void main(String[] args) {

        new ThreadTest().start();

        // sleepThread 不停的尝试睡眠
//        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
//        sleepThread.setDaemon(true);

        // busyThread 不停的运行
//        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
//        busyThread.setDaemon(true);

//        sleepThread.start();
//        busyThread.start();

        // 休眠 5 秒，让 sleepThread 和 busyThread 充分运行
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        busyThread.interrupt();

//        System.out.println("sleepThread interrupted is " + sleepThread.isInterrupted());
//        System.out.println("busyThread interrupted is " + busyThread.isInterrupted());

//        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable{

        Lock lock = new ReentrantLock();
        @Override
        public void run() {
//            synchronized (Interrupted.class){

            lock.lock();
            while (true){
//                    SleepUtils.second(10);
            }
//            }

        }
    }

    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    static class ThreadTest extends Thread{
        @Override
        public void run() {
            System.out.println("dsdssds");
        }
    }
}
