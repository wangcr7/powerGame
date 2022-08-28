package thread.Thread_012;

import thread.ThreadTest.SleepUtils;


/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-21 16:59
 */
public class T1 {

    void m (){
        System.out.println("Shutdown start...");
        while (!Thread.currentThread().isInterrupted()){

        }
        System.out.println("Shutdown end...");
    }

    public static void main(String[] args) {

        T1 t1 = new T1();
        Thread thread = new Thread(t1 :: m, "shutdown");
        SleepUtils.second(2);

        thread.interrupt();
    }
}
