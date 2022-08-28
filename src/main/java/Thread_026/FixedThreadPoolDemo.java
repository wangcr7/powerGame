package Thread_026;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-29 13:41
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        MyRunnable mr1 = new MyRunnable(10, "mr1");
        MyRunnable mr2 = new MyRunnable(5, "mr2");
        MyRunnable mr3 = new MyRunnable(10, "mr3");

        es.submit(mr1);
        es.submit(mr2);
        es.submit(mr3);

        es.shutdown();
    }

    static class MyRunnable implements Runnable {
        private int count;
        private String name;

        public MyRunnable(int count, String name) {
            this.count = count;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }
    }
}
