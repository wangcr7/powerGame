package thread.Thread_025;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: WChi_Add_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-26 01:01
 */
public class T05_LinkedBlockingQueue_Test {

    static BlockingQueue queue = new LinkedBlockingQueue();

    public static void main(String[] args) {

        queue.add(00);

        try {
            queue.put("f");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        queue.offer("a");

        queue.offer("b");

//        queue.add("a");

        queue.clear();




    }
}
