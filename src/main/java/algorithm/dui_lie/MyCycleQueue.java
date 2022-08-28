package algorithm.dui_lie;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-03 00:15
 */
public class MyCycleQueue {

    private int [] array;
    private int maxSize;
    private int front;
    private int rear;

    public MyCycleQueue(){
        array = new int[10];
        maxSize = 10;
        front = 0;
        rear = 0;
    }

    public MyCycleQueue(int _maxSize){
        maxSize = _maxSize;
        array = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean insert(MyCycleQueue myCycleQueue, int value){
        if ((rear + 1)%maxSize == front){
            System.out.println("队列上溢出");
            return false;
        }
        rear = (rear + 1)%maxSize;
        myCycleQueue.array[rear] = value;
        System.out.println("插入成功" + value);
        return true;
    }

    public int remove(MyCycleQueue myCycleQueue){
        if (myCycleQueue.front == myCycleQueue.front){
            return 0;
        }
        front = (front + 1)% maxSize;
        return myCycleQueue.array[front];
    }

    public boolean isEmpty(MyCycleQueue myCycleQueue){
        return myCycleQueue.front == myCycleQueue.rear;
    }

    public static void main(String[] args) {
        MyCycleQueue myCycleQueue = new MyCycleQueue(4);
        for (int i = 0; i < 8; i++) {
            myCycleQueue.insert(myCycleQueue, i);
        }

    }
}
