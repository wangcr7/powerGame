package thread.Thread_026;

import thread.ThreadTest.SleepUtils;

import java.util.concurrent.*;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-28 20:55
 */
public class T06_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                SleepUtils.second(1);
                return 1000;
            }
        });

        /**
         * 有返回值的创建线程
         */
        new Thread(task).start();

        System.out.println(task.get());

        // ***********************

        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<Integer> f = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                SleepUtils.second(1);
                return 1000;
            }
        });

        System.out.println(f.get());
        System.out.println(f.isDone());

    }
}
