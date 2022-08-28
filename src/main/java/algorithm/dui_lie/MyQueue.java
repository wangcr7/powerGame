package algorithm.dui_lie;

/**
 * @program: Real_Madrid_2020
 * @description: 普通队列
 * @author: wang chi
 * @create: 2020-06-02 23:34
 */
public class MyQueue {

    private int [] array;
    private int maxSize;
    private int front;
    private int rear;

    public MyQueue(){
        array = new int[10];
        maxSize = 10;
        front = -1;
        rear = -1;
    }

    public boolean insert (MyQueue myQueue, int value){

        if (myQueue.rear == myQueue.maxSize - 1){
            System.out.println("对列上溢出");
            return false;
        }
        myQueue.rear++;
        array[rear] = value;
        return true;
    }

    public int remove (MyQueue myQueue){
        if (myQueue.rear == myQueue.front){
            return 0;
        } else {
            myQueue.front++;
            return myQueue.array[front];
        }
    }

    public boolean isEmpty(MyQueue myQueue){
        return myQueue.front == myQueue.rear;
    }

}
