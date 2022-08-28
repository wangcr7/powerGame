package algorithm.zhan;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-02 22:45
 */
public class ArrayStack {

    private int top;
    private int capacity;
    private long[] array;

    public ArrayStack() {
        capacity = 10;
        array = new long[capacity];
        top = -1;
    }

    public ArrayStack(int _capacity){
        capacity = _capacity;
        array = new long[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isStackFull (){
        return (top == capacity - 1);
    }

    public void push (int data){

        if (isStackFull()){
            System.out.println("stack overflow...");
        } else {
            array[++top] = data;
        }
    }

    public long pop(){
        if (isEmpty()){
            System.out.println("stack is Empty...");
            return 0;
        } else {
            return array[top--];
        }
    }

    public long peek (){
        return array[top];
    }

}
