package Thread_025;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @program: WChi_Add_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-23 14:55
 */
public class T07_DelayQueue {

    static BlockingQueue taks = new DelayQueue();

    static class MyTask implements Delayed{

        long runningTime;

        MyTask(long _runingTime){
            runningTime = _runingTime;
        }
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)){
                return -1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)){
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return ""+ runningTime;
        }
    }

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        System.out.println(System.currentTimeMillis());

        MyTask myTask1 = new MyTask(now + 1000);
        MyTask myTask2 = new MyTask(now + 1500);
        MyTask myTask3 = new MyTask(now + 2000);
        MyTask myTask4 = new MyTask(now + 2500);
        MyTask myTask5 = new MyTask(now + 500);

        try {
            taks.put(myTask1);
            taks.put(myTask2);
            taks.put(myTask3);
            taks.put(myTask4);
            taks.put(myTask5);

            System.out.println(taks);

            for (int i = 0; i < 5; i++) {
                System.out.println(taks.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
