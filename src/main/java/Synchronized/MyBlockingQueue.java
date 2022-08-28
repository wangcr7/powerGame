package Synchronized;


import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: TestJava
 * @description: 实现阻塞队列
 * @author: wang chi
 * @create: 2020-05-11 12:59
 */
public class MyBlockingQueue<E> {
    /**
     * 队列的最大长度
     */
    int size;
    ReentrantLock lock = new ReentrantLock();
    /**
     *  队列的底层实现
     */
    LinkedList<E> linkedList = new LinkedList<>();
    /**
     * 队列满时的等待条件
     */
    Condition notFull = lock.newCondition();
    /**
     * 队列空时的等待条件
     */
    Condition notEmpty = lock.newCondition();
    public MyBlockingQueue (int _size){
        size = _size;
    }

    /**
     * 入队
     * @param e
     * @throws InterruptedException
     */
    public void enqueue (E e) throws InterruptedException{

        lock.lock();
        try {
            while (linkedList.size() == size){
                /**
                 * 队列已满，在 notFull 条件上进行等待
                 */
                notFull.await();
            }
            /**
             * 入队
             */
            linkedList.add(e);
            System.out.println("入队：" + e);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
    public E dequeue () throws InterruptedException{

        E e;
        lock.lock();
        try {
            while (linkedList.size() == 0){
                /**
                 * 队列已空，在 notEmpty 条件上进行等待
                 */
                notEmpty.await();
            }
            e = linkedList.removeFirst();
            System.out.println("出队：" + e);
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(2);
        for (int i = 0;i < 10;i++){
            int data = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.enqueue(data);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Integer data = queue.dequeue();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
