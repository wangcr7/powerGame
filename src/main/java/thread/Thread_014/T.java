package thread.Thread_014;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-21 17:22
 */
public class T {

    /*volatile*/ int count = 0;
    /*synchronized*/ void m(){
        for (int i = 0;i < 10000;i++){
            count++;
        }
    }

    public static void main(String[] args) {
        T t = new T();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-"+ i));
        }
        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
