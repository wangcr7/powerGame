package thread.Thread_024;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-22 12:55
 */
public class TicketSeller3 {

    static List<String> ticket = new ArrayList<>();

    static {
        for (int i = 0; i < 1000; i++) {
            ticket.add("票编号" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        synchronized (ticket){
                            if (ticket.size() <= 0){
                                break;
                            }

                            try {
                                TimeUnit.MILLISECONDS.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("销售了---" + ticket.remove(0));
                        }
                    }
                }
            }).start();
        }
    }
}
