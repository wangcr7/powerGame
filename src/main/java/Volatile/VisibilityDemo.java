package Volatile;



public class VisibilityDemo extends Thread {
    private volatile static boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {

        new VisibilityDemo().start();
        Thread.sleep(100);
        isRunning = false;
        System.out.println("我已经修改了标志变量，isRunning = " + isRunning);

    }

    @Override
    public void run() {
        while(isRunning) {
        }
        System.out.println("线程被停止了");

    }
}


