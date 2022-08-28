package thread.Thread_026;


import java.util.concurrent.Executor;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-28 20:06
 */
public class T01_MyExcetor implements Executor {

    @Override
    public void execute(Runnable command) {
//        command.run();
        new Thread(command).start();
    }

    public static void main(String[] args) {
        new T01_MyExcetor().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("a");
            }
        });
    }
}
