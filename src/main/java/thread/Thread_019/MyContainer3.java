package thread.Thread_019;

import thread.ThreadTest.SleepUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-21 18:24
 */
public class MyContainer3 {

    List list = new ArrayList();

    public void add(Object object){
        list.add(object);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        final Object o = new Object();
        MyContainer3 myContainer3 = new MyContainer3();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    if (myContainer3.size() != 5){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("t2 结束");
                    o.notify();
                }
            }
        }, "t2").start();

        SleepUtils.second(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i = 0;i < 10;i++){
                        myContainer3.add(new Object());
                        System.out.println(myContainer3.size());
                        if (myContainer3.size() == 5){
                            o.notify();

                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        SleepUtils.second(1);

                    }
                }
            }
        }, "t1").start();
    }
}
