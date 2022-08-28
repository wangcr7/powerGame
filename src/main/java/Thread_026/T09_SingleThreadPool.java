package Thread_026;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-29 00:20
 */
public class T09_SingleThreadPool {

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
