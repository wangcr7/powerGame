package test_synchronized;

import thread.ThreadTest.SleepUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: WChi_Add_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-23 18:18
 */
class Mutex implements Lock {

    private final Sync sync = new Sync();

    // 静态内部类，自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer{

        // 是否处于占用状态
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // 当状态为 0 的时候获取锁
        @Override
        protected boolean tryAcquire(int acquires){
            if (compareAndSetState(0, acquires)){
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int releases){
            if (getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 返回一个 Condition，每个 Condition 都包含了一个 Condition 队列
        Condition newCondition(){
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }

    public static void main(String[] args) {

        Mutex mutex = new Mutex();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mutex.lock();

                SleepUtils.second(1);
                mutex.unlock();
            }
        }).start();

        SleepUtils.second(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                mutex.lock();
            }
        }).start();
    }
}
