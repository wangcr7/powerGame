package Thread_022;

import ThreadTest.SleepUtils;



/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-22 00:11
 */
public class ThreadLocalTest {

    static ThreadLocal<person> threadLocal = new ThreadLocal();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                SleepUtils.second(2);
                System.out.println(threadLocal.get());
            }
        }).start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SleepUtils.second(1);
                threadLocal.set(new person());
            }
        });

        thread.start();
    }
    static class person{
        String name = "zhangsan";
    }
}