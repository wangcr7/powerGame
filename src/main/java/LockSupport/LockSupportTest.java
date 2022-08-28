package LockSupport;

import ThreadTest.SleepUtils;

import java.util.concurrent.locks.LockSupport;

/**
 * @program: WChi_Add_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-24 15:21
 */
public class LockSupportTest {

    public static void main(String[] args) {
        Thread parkThread = new Thread(new ParkThread());
        parkThread.start();

        SleepUtils.second(1);
        System.out.println("开始线程唤醒");
        LockSupport.unpark(parkThread);
        System.out.println("结束线程唤醒");

    }

    static class ParkThread implements Runnable{

        @Override
        public void run() {
            System.out.println("开始线程阻塞");
            LockSupport.park();
            System.out.println("结束线程阻塞");
        }
    }
}
