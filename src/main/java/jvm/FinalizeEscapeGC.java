package jvm;

import ThreadTest.SleepUtils;



/**
 * @program: Real_Madrid_2020
 * @description: （1）对象可以在 GC 时进行自我拯救 （2）这种自救的机会之后一次，因为一个对象的 finalize() 最多自会被系统调用一次
 * @author: wang chi
 * @create: 2020-05-31 12:01
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive (){
        System.out.println("yes,i am is alive:");
    }

//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//        System.out.println("finalize method executed!");
//        FinalizeEscapeGC.SAVE_HOOK = this;
//    }

    public static void main(String[] args) {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为 Finalizer 方法的优先级很低，暂停一秒，以等待它
        SleepUtils.second(1);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead:");
        }

        // 下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为 Finalizer 方法的优先级很低，暂停一秒，以等待它
        SleepUtils.second(1);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead:");
        }
    }
}
