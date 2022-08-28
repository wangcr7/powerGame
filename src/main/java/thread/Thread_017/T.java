package thread.Thread_017;

import thread.ThreadTest.SleepUtils;


/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-21 18:02
 */
public class T {

    Object o = new Object();

    void m(){
        synchronized (o){
            while (true){
                SleepUtils.second(1);
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t :: m, "t1").start();

        SleepUtils.second(3);

        Thread thread = new Thread(t::m, "t2");
        t.o = new Object();
        thread.start();



    }
}
