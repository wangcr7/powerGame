package thread.Thread_021;

import thread.ThreadTest.SleepUtils;

import java.util.LinkedList;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-21 23:08
 */
public class MyContainer1<T> {

    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;


    public synchronized void put(T t){
        while (list.size() == MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get(){
        T t = null;
        while (list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count --;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {

        MyContainer1<String> myContainer1 = new MyContainer1<>();

        for (int i = 0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0;j<5;j++){
                        System.out.println(myContainer1.get());
                    }
                }
            }, "c" + i).start();
        }

        SleepUtils.second(2);

        for (int i = 0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<25;j++){
                        myContainer1.put(Thread.currentThread().getName() + " " + j);
                    }
                }
            }, "p" + i).start();
        }

    }
}
