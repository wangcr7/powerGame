package jvm;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-04 20:49
 */
public class DeadLoopClass {

    static {
        // 如果不加上这个if语句，编译器将提示“Initializer does not complete normally”并拒绝编译
        if (true) {
            System.out.println(Thread.currentThread() + "init DeadLoopClass");
            while (true) {
            }
        }
    }
}
