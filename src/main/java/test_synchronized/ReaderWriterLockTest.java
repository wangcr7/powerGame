package test_synchronized;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-27 14:18
 */
public class ReaderWriterLockTest {

    public static void main(String[] args) {
        //创建并发访问的账户
        MyCount myCount = new MyCount("95599200901215522", 10000);
        //创建一个锁对象
        ReadWriteLock lock = new ReentrantReadWriteLock(false);

        // 创建一些并发访问的账户，一个信用卡，存的存，取的取
        // 3 个写锁， 3 个读锁

        new Thread(new User("张三他爹", myCount, 0, lock, true), "read1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new User("张三他弟", myCount, 0, lock, true), "read2").start();

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new User("张三", myCount, 0, lock, true), "read3").start();

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new User("张三", myCount, -4000, lock, false), "write1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new User("张三他爹", myCount, 6000, lock, false), "write2").start();

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new User("张三", myCount, 800, lock, false), "write3").start();
    }
}

class User implements Runnable{

    /**
     * 用户名
     */
    private String name;

    /**
     * 所要操作的账户
     */
    private MyCount myCount;

    /**
     * 操作的金额，有正负之分
     */
    private int iocash;

    /**
     *  执行操作所需要的🔒对象
     */
    private ReadWriteLock myLock;

    /**
     * 是否查询
     */
    private boolean isCheck;

    public User(String name, MyCount myCount, int iocash, ReadWriteLock myLock, boolean isCheck) {
        this.name = name;
        this.myCount = myCount;
        this.iocash = iocash;
        this.myLock = myLock;
        this.isCheck = isCheck;
    }

    @Override
    public void run() {

        if (isCheck){
            // 获取读锁
            myLock.readLock().lock();
            myLock.readLock().lock();
            myLock.readLock().lock();
            System.out.println("读：" + name + "正在查询" + myCount + "账户，当前金额为" + myCount.getCash());
            myLock.readLock().unlock();
        } else {
            //获取写锁
            myLock.writeLock().lock();
            myLock.writeLock().lock();
            //执行现金业务
            System.out.println("写：" + name + "正在操作" + myCount + "账户，金额为" + iocash +"，当前金额为" + myCount.getCash());
            myCount.setCash(myCount.getCash() + iocash);
            System.out.println("写：" + name + "操作" + myCount + "账户成功，金额为" + iocash +"，当前金额为" + myCount.getCash());
            //释放写锁
            myLock.writeLock().unlock();
        }
    }
}

class MyCount{
    /**
     * 账号
     */
    private String oid;

    /**
     * 账户余额
     */
    private int cash;

    public MyCount(String oid, int cash) {
        this.oid = oid;
        this.cash = cash;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getOid() {
        return oid;
    }

    public int getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return "MyCount{" +
                "oid='" + oid + '\'' +
                ", cash=" + cash +
                '}';
    }
}
