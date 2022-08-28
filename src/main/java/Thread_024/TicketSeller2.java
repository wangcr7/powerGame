package Thread_024;


import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-22 12:00
 */
public class TicketSeller2 {

    static Vector<String> vector = new Vector<>();

    static {
        for (int i = 0; i < 10000; i++) {
            vector.add("票编号" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (vector.size() > 0){
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了---" + vector.remove(0));
                    }
                }
            }).start();
        }
    }
}
