package Thread_019;

import ThreadTest.SleepUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: TestJava
 * @description: 实现一个容器，提供两个方法，add size
 * 写两个线程，线程1添加10个元素到容器中，线程2监视元素的个数，当个数达到5个时，线程2给出提示并结束
 * 问题1：t2 线程监视到 size = 5 的时候，此时还没有来得及 break，t1 线程又往 list 里面加了一个元素，不是很精确
 * 问题2：t2 线程浪费 cpu
 * @author: wang chi
 * @create: 2020-05-21 18:24
 */
public class MyContainer1 {

    List list = new ArrayList();

    public void add(Object object){
        list.add(object);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer1 myContainer1 = new MyContainer1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<10;i++){
                    myContainer1.add(new Object());
                    System.out.println(myContainer1.size());
                    SleepUtils.second(1);
                }
            }
        }, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (myContainer1.size() == 5){
                        System.out.println("容器内的数量5个了...");
                        break;
                    }
                }
            }
        },"t2").start();
    }
}
