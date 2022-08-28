package test_synchronized;


import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.cnblogs.com/takumicx/p/9338983.html
 */

/**
 * @program: TestJava
 * @description: 可重入的
 * @author: wang chi
 * @create: 2020-05-11 11:12
 */
public class ReentrantLockTest_1 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0;i<3;i++){
            reentrantLock.lock();
        }
        for (int i = 0;i<4;i++){
            try {

            } finally {
                reentrantLock.unlock();
            }
        }
        System.out.println();
    }
}
