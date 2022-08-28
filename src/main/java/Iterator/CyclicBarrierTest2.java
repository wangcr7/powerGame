package Iterator;


import java.util.concurrent.CyclicBarrier;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-28 18:19
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(2, new A());
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {
        }
        System.out.println(2);
    }
    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
