package ThreadTest;

import java.util.concurrent.TimeUnit;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-19 21:08
 */
public class SleepUtils {

    public static final void second (long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
