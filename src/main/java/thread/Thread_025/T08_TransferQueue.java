package thread.Thread_025;

import thread.ThreadTest.SleepUtils;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @program: WChi_Add_2020
 * @description:
 * 需要先启动消费者线程。如果先 transfer ，没有消费者线程时，会阻塞（add，offer,put 不会阻塞）
 * @author: wang chi
 * @create: 2020-05-23 15:49
 */
public class T08_TransferQueue {

    public static void main(String[] args) {


        TransferQueue<String> transferQueue = new LinkedTransferQueue();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(transferQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        SleepUtils.second(1);*/

        try {
            transferQueue.transfer("aaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SleepUtils.second(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(transferQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
