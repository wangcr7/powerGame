package thread.Thread_026;

import thread.ThreadTest.SleepUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-29 00:22
 */
public class T10_ScheduleThreadPool {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                SleepUtils.second(1);
                System.out.println(Thread.currentThread().getName());
            }
        }, 0, 500, TimeUnit.MILLISECONDS);
    }
}
