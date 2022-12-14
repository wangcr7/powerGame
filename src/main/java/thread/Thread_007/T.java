package thread.Thread_007;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-20 19:58
 */
public class T {

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + "m1 start....");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "m1 end");
    }

    public void m2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m2");
    }

    public static void main(String[] args) {
        T t = new T();

        new Thread(() -> t.m1(), "t1").start();
        new Thread(() -> t.m2(), "t2").start();

        /*new Thread(t :: m1, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        }).start();*/

    }
}
