package algorithm.dui_lie;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-03 00:45
 */
public class MyCycleQueue1 {

    private int [] array;
    private int maxSize;
    private int front;
    private int count;

    public MyCycleQueue1(){
        array = new int[10];
        maxSize = 10;
        front = 0;
        count = 0;
    }

    public MyCycleQueue1(int _maxSize){
        maxSize = _maxSize;
        array = new int[maxSize];
        front = 0;
        count = 0;
    }

    public boolean insert(MyCycleQueue1 myCycleQueue1, int value){
        int rear; // 设置临时指针
        if (myCycleQueue1.count == myCycleQueue1.maxSize){
            System.out.println("队列上溢出");
            return false;
        }
        rear = (myCycleQueue1.front + myCycleQueue1.count)%maxSize;
        rear = (rear + 1)%maxSize;
        myCycleQueue1.array[rear] = value;
        count++;
        System.out.println("插入成功" + value);
        return true;
    }

    public int remove(MyCycleQueue1 myCycleQueue1){
        if (myCycleQueue1.count == 0){
            return 0;
        }
        front = (front + 1)%maxSize;
        count--;
        return myCycleQueue1.array[front];
    }

    public boolean isEmpty(MyCycleQueue1 myCycleQueue1){
        return count == 0;
    }

    public static void main(String[] args) {
        MyCycleQueue1 myCycleQueue1 = new MyCycleQueue1(4);
        for (int i = 0; i < 8; i++) {
            myCycleQueue1.insert(myCycleQueue1, i);
        }

    }
}
