package Thread_026;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-28 20:40
 */
public class   T05_ThreadPool {

    public static void main(String[] args) {

        ExecutorService service = new ThreadPoolExecutor(
                3, 5 , 5, TimeUnit.SECONDS, new LinkedBlockingQueue());

        for (int i = 0; i < 4; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(service);

        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });


//        System.out.println(service);
//
//        service.shutdown();
//        System.out.println(service.isTerminated());
//        System.out.println(service.isShutdown());
//        System.out.println(service);
//
//        SleepUtils.second(8);
//
//        System.out.println(service.isTerminated());
//        System.out.println(service.isShutdown());
//        System.out.println(service);


    }
}
