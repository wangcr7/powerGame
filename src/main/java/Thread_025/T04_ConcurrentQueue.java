package Thread_025;

import ThreadTest.SleepUtils;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @program: WChi_Add_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-23 00:53
 */
public class T04_ConcurrentQueue {

    Queue<String> strings = new ConcurrentLinkedQueue<>();

    public void offered(){
        strings.offer("a");
        strings.offer("b");
        strings.offer("c");
        strings.offer("d");
    }

    public void poll (){
        strings.poll();
        strings.poll();
        strings.poll();
        strings.poll();
        strings.poll();
    }

    public static void main(String[] args) {

        T04_ConcurrentQueue t04_concurrentQueue = new T04_ConcurrentQueue();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                t04_concurrentQueue.offered();
//            }
//        }, "t1").start();

        SleepUtils.second(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                t04_concurrentQueue.poll();
            }
        }, "t2").start();

//        for (int i = 0;i<10;i++){
//            strings.offer("a" + i );
//        }



//        System.out.println(strings);
//
//        System.out.println(strings.size());
//
//        System.out.println(strings.poll());
//        System.out.println(strings.size());
//
//        System.out.println(strings.peek());
//        System.out.println(strings.size());
    }
}
