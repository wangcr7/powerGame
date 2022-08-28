package Synchronized;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-26 19:08
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.toString();
        print(queue);
        queue.offer("aaa");
        print(queue);
        queue.offer("bbb");
        print(queue);
        queue.offer("ccc");
        print(queue);
    }

    /**
     * 打印并发队列head属性的identityHashCode
     * @param queue
     */
    private static void print(ConcurrentLinkedQueue queue) {
        Field field = null;
        boolean isAccessible = false;
        try {
            field = ConcurrentLinkedQueue.class.getDeclaredField("head");
            isAccessible = field.isAccessible();
            if (!isAccessible) {
                field.setAccessible(true);
            }
            System.out.println("head: " + System.identityHashCode(field.get(queue)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            field.setAccessible(isAccessible);
        }
    }
}
