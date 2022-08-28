package Thread_005;



/**
 * @program: TestJava
 * @description: 线程重入/synchronized 代码块是原子操作，不可分的
 * @author: wang chi
 * @create: 2020-05-20 15:56
 */
public class T implements Runnable {

    private int count = 10;

    @Override
    public /*synchronized*/ void run() {

        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }

    public static void main(String[] args) {

        T t = new T();

        for (int i = 0;i < 5;i++){
            new Thread(t, "THREAD" + i).start();
        }
    }
}
