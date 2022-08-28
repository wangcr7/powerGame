package Thread_026;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-28 21:10
 */
public class T07_ParallelComputing {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Integer> result = getPrime(1, 200000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        ExecutorService service = Executors.newFixedThreadPool(4);

        MyTask myTask1 = new MyTask(1, 80000);
        MyTask myTask2 = new MyTask(80001, 13000);
        MyTask myTask3 = new MyTask(13001, 17000);
        MyTask myTask4 = new MyTask(17001, 20000);

        Future<List<Integer>> future1 = service.submit(myTask1);
        Future<List<Integer>> future2 = service.submit(myTask2);
        Future<List<Integer>> future3 = service.submit(myTask3);
        Future<List<Integer>> future4 = service.submit(myTask4);

        start = System.currentTimeMillis();
        try {
            future1.get();
            future2.get();
            future3.get();
            future4.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static class MyTask implements Callable<List<Integer>>{

        int start;
        int end;

        MyTask(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public List<Integer> call() throws Exception {
            return getPrime(start, end);
        }
    }

    static boolean isPrime( int num){
        for (int i = 2; i < num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static List<Integer> getPrime(int start, int end){
        List<Integer> results = new ArrayList<>();
        for (int i = start;i<=end;i++){
            if (isPrime(i)){
                results.add(i);
            }
        }
        return results;
    }
}
