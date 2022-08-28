package Thread_011;

import ThreadTest.SleepUtils;



/**
 * @program: TestJava
 * @description: 抛出异常后锁将被释放
 * @author: wang chi
 * @create: 2020-05-21 15:42
 */
public class T {

    int count = 0;

    synchronized void m(){
        System.out.println(Thread.currentThread().getName() + "start");
        while (true){
            count++;
            System.out.println(Thread.currentThread().getName() + "count =" + count);
            SleepUtils.second(1);
            if (count == 5){
                int i = 1/0;
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r, "thread").start();

        SleepUtils.second(1);

        t.m();
    }
}
