package Thread_025;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: WChi_Add_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-23 01:21
 */
public class T05_LinkedBlockingQueue {

    static BlockingQueue queue = new LinkedBlockingQueue();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        queue.put("a" + i);
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            System.out.println(Thread.currentThread().getName() + "take" + queue.take());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "a" + i).start();
        }
    }
}
