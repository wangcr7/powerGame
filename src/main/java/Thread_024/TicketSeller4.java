package Thread_024;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-22 13:10
 */
public class TicketSeller4 {

    static Queue<String> ticket = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            ticket.add("票编号" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String s = ticket.poll();
                        if (s == null){
                            break;
                        } else {
                            System.out.println("销售了" + s);
                        }
                    }
                }
            }).start();
        }
    }
}
