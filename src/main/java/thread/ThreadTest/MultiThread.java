package thread.ThreadTest;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;


/**
 * @program: TestJava
 * @description:
 * @author: wang chi
 * @create: 2020-05-19 19:51
 */
public class MultiThread {

    public static void main(String[] args) {
        // 获取线程管理
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // 不需要获取同步的 monitor 和 synchronized 信息，仅获取线程和线程堆栈信息
        ThreadInfo [] threadInfos = threadMXBean.dumpAllThreads(false, false);

        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo:threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }
}
