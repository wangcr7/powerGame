package ThreadTest;



/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-20 00:05
 */
public class ThreadJoin {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                SleepUtils.second(5);
                System.out.println("hahahha");
                while (true){

                }
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("1111111");
    }
}
