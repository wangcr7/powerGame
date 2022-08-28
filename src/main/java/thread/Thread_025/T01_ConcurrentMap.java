package thread.Thread_025;


import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-22 13:43
 */
public class T01_ConcurrentMap {
    public static void main(String[] args) {

        Map map = new ConcurrentHashMap<>();
//        Map map = new ConcurrentSkipListMap();

//        Map map = new Hashtable();
//        Map map = new HashMap();

        Random r = new Random();
        Thread[] ths = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(ths.length);
        long start = System.currentTimeMillis();

        for (int i = 0;i<ths.length;i++){
            ths[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0;j<10000;j++){
                        map.put("a" + r.nextInt(10000), "a" + r.nextInt(10000));
                    }
                    countDownLatch.countDown();
                }
            });
        }


        Arrays.asList(ths).forEach(t -> t.start());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
