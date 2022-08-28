package thread.Thread_012;

import thread.ThreadTest.SleepUtils;


/**
 * @program: TestJava
 * @description: voliate 关键字
 * @author: wang chi
 * @create: 2020-05-21 16:54
 */
public class T {

    /*volatile*/ boolean running = true;
    void m (){
        System.out.println("m start...");
        while (running){

            SleepUtils.second(3);
        }
        System.out.println("m end...");
    }

    public static void main(String[] args) {

        T t = new T();
        new Thread(t :: m,"t1").start();

        SleepUtils.second(2);

        t.running = false;
    }
}
