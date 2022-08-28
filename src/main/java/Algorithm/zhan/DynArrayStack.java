package Algorithm.zhan;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-02 23:18
 */
public class DynArrayStack {

    private int top;
    private int capacity;
    private long [] array;

    public DynArrayStack(){
        capacity = 1;
        array = new long[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isStackFull (){
        return (top == capacity - 1);
    }

    private void doubleStack (){
        long[] newArray = new long[capacity * 2];
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity = capacity * 2;
        array = newArray;
    }

    public void push (int data){
        if (isStackFull()){
            doubleStack();
        }
        array[++top] = data;
    }

    public long pop(){
        if (isEmpty()){
            System.out.println("stack is Empty...");
            return 0;
        } else {
            return array[top--];
        }
    }
}
