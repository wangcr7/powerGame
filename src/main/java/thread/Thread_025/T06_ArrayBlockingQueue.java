package thread.Thread_025;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: WChi_Add_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-23 01:18
 */
public class T06_ArrayBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<String> stringQueue = new ArrayBlockingQueue<>(2);

//        for (int i = 0; i < 10; i++) {
//            stringQueue.offer("a" + i);
//        }
//
//        stringQueue.offer("a");
//        try {
//            stringQueue.offer("a", 5, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        stringQueue.add("a");

        for (int i = 0; i < 5; i++) {
            try {
                stringQueue.offer("a" + i, 2, TimeUnit.SECONDS );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0;i<5;i++){

            try {
                stringQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
