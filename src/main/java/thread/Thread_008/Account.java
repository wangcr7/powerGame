package thread.Thread_008;

import thread.ThreadTest.SleepUtils;

/**
 * @program: TestJava
 * @description: 脏读现象：仅仅对写进行加锁，没有对读进行加锁，那么有可能会读到写过程中还没有完成的数据。解决：读也加锁
 * @author: wang chi
 * @create: 2020-05-20 20:12
 */
public class Account {

    String name;
    double balance;

    public synchronized void set (String name, double balance){
        this.name = name;

        SleepUtils.second(2);

        this.balance = balance;
    }

    public /*synchronized*/ double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {

        Account a = new Account();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.set("zhangsan", 100.0);
            }
        }).start();

        SleepUtils.second(1);

        System.out.println(a.getBalance("zhangsan"));

        SleepUtils.second(2);

        System.out.println(a.getBalance("zhangsan"));

    }
}
