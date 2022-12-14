package test_synchronized;



public class T1 {

    public static void main(String[] args) {
        Synchronized syn = new Synchronized();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    syn.thisMethod();
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    syn.instanceMethod();
                }
            }.start();
        }
    }

}
