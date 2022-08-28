package Thread_019;

import ThreadTest.SleepUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: TestJava
 * @description: 使用 wait() 和 notify()
 * @author: wang chi
 * @create: 2020-05-21 18:24
 */
public class MyContainer2 {

    volatile List list = new ArrayList();

    public void add(Object object){
        list.add(object);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {

        MyContainer2 myContainer2 = new MyContainer2();
        final Object o = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    if (myContainer2.size() != 5){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("t2 结束");
                }
            }
        }, "t2").start();

        SleepUtils.second(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i = 0;i < 10;i++){
                        myContainer2.add(new Object());
                        System.out.println(myContainer2.size());
                        if (myContainer2.size() == 5){
                            o.notify();
                            break;
                        }
                        SleepUtils.second(1);

                    }
                }
            }
        }, "t1").start();



    }
}
