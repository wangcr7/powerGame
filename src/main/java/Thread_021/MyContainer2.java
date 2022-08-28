package Thread_021;

import ThreadTest.SleepUtils;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-22 00:00
 */
public class MyContainer2<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 2;
    private int count = 0;
    Lock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();
    public void put(T t){
        try {
            lock.lock();
            while (list.size() == MAX){
                producer.await();
            }
            list.add(t);
            ++count;
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public T get(){
        T t = null;
        try {
            lock.lock();
            while (list.size() == 0){
                consumer.await();
            }
            t = list.removeFirst();
            count--;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {

        MyContainer2<String> myContainer2 = new MyContainer2<>();

        for (int i = 0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0;j<2;j++){
                        System.out.println(myContainer2.get());
                    }
                }
            }, "c" + i).start();
        }

        SleepUtils.second(60);

        for (int i = 0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<4;j++){
                        myContainer2.put(Thread.currentThread().getName() + " " + j);
                    }
                }
            }, "p" + i).start();
        }

    }

}