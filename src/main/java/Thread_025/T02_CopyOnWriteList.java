package Thread_025;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-23 00:14
 */
public class T02_CopyOnWriteList {

    public static void main(String[] args) {

        List list =
                //new ArrayList();
                new Vector<>();
                //new CopyOnWriteArrayList<>();

        Random r = new Random();
        Thread[] ths = new Thread[100];

        for (int i=0; i < ths.length;i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        list.add("a" + r.nextInt(10000));
                    }
                }
            };
            ths[i] = new Thread(task);
        }

        long s1 = System.currentTimeMillis();
        Arrays.asList(ths).forEach(t -> t.start());
        Arrays.asList(ths).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long s2 = System.currentTimeMillis();

        System.out.println(s2 - s1);

        System.out.println(list.size());
    }
}
