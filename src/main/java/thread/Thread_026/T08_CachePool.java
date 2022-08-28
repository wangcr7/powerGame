package thread.Thread_026;

import thread.ThreadTest.SleepUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-28 23:21
 */
public class T08_CachePool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println(executorService);

        for (int i = 0; i < 2; i++) {

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    SleepUtils.second(1);
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        System.out.println(executorService);
        SleepUtils.second(70);
        System.out.println(executorService);
    }
}
