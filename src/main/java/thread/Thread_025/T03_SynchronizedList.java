package thread.Thread_025;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-23 00:25
 */
public class T03_SynchronizedList {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();

        // 线程安全的
        List<String> strSync = Collections.synchronizedList(strs);
    }
}
