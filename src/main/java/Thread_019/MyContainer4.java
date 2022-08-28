package Thread_019;

import ThreadTest.SleepUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-21 18:24
 */
public class MyContainer4 {

    List list = new ArrayList();

    public void add(Object object){
        list.add(object);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer4 myContainer4 = new MyContainer4();
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (myContainer4.size() != 5){
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
            }
        }, "t2").start();

        SleepUtils.second(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < 10;i++){
                    myContainer4.add(new Object());
                    System.out.println(myContainer4.size());
                    if (myContainer4.size() == 5){
                        countDownLatch.countDown();
                    }
                    SleepUtils.second(1);
                }
            }
        }, "t1").start();
    }


}
