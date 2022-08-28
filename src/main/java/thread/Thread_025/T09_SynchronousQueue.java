package thread.Thread_025;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @program: WChi_Add_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-23 15:59
 */
public class T09_SynchronousQueue {

    public static void main(String[] args) throws InterruptedException{

        BlockingQueue queue = new SynchronousQueue();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/

            queue.put("aa"); //底层使用 transfer 实现,阻塞等待消费者消费
            //queue.add("a"); //直接报错，无这个方法
    }
}
