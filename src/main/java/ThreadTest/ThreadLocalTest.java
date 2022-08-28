package ThreadTest;



/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-20 10:41
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Integer> TL_INT = ThreadLocal.withInitial(() -> 6);

    public static void main(String[] args) {

        TL_INT.get();

        TL_INT.set(TL_INT.get() + 1);

        System.out.println(TL_INT.get());

        TL_INT.remove();

        System.out.println(TL_INT.get());
    }
}
