package thread.ThreadTest;



/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-19 21:03
 */
public class ThreadState {

    public static void main(String[] args) {
        Thread thread = new Thread(new TimeWaiting(), "TimeWaitingThread");
        thread.start();

//        new Thread(new Waiting(), "WaitingThread").start();
//
//        new Thread(new Blocked(), "BlockedThread-1").start();
//        new Thread(new Blocked(), "BlockedThread-2").start();

//        SleepUtils.second(1);
//
//        thread.interrupt();
//
//        System.out.println(thread.isInterrupted());

    }

    static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Waiting implements Runnable{
        @Override
        public void run() {
            while (true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class Blocked implements Runnable{
        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
//                    SleepUtils.second(100);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}




