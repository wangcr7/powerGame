package Thread_026;

public class test implements Runnable {


    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    private static int workerCountOf(int c)  { return c & CAPACITY; }

    @Override
    public void run() {


        System.out.println(this);
    }


    public static void main(String[] args) {


        System.out.println(workerCountOf(Integer.MAX_VALUE));

        System.out.println(Integer.MAX_VALUE);


//        test test = new test();
//
//        System.out.println(test);
//        new Thread(test).start();
    }
}

