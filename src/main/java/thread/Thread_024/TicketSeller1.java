package thread.Thread_024;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-22 10:21
 */
public class TicketSeller1 {

    static List<String> ticket = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            ticket.add("票编号" + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (ticket.size() > 0){
                        System.out.println("销售了---" + ticket.remove(0));
                    }
                }
            }).start();
        }
    }
}
