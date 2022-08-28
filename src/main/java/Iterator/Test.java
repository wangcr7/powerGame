package Iterator;



/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-27 10:59
 */
public class Test {

//    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int EXCLUSIVE_MASK = (1 << 16) - 1;

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static final int fun (int c){
        return c & EXCLUSIVE_MASK;
    }

    static int sharedCount(int c)    { return c >>> 16; }

    static int fun1(int initialCapacity){
        int cap = ((initialCapacity >= (MAXIMUM_CAPACITY >>> 1)) ?
                MAXIMUM_CAPACITY :
                tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1));

        return cap;
    }

    public static void main(String[] args) {

        String str = "abc";
//        String string = "cba";
//        System.out.println(str.hashCode());
//        System.out.println(string.hashCode());


        System.out.println(fun1(5));
    }
}
