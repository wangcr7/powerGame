package algorithm.zhan;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-04 00:00
 */
public class ListStack {

    /**
     * 栈顶元素
     */
    Node header;
    /**
     * 栈内元素个数
     */
    int elementCount;
    /**
     * 栈的大小
     */
    int size;

    /**
     * 构造函数，构造一个空的栈
     */
    public ListStack(){
        header = null;
        elementCount = 0;
        size =0;
    }

    /**
     * 通过构造器自定义栈的大小
     * @param size
     */
    public ListStack(int size) {
        header = null;
        elementCount = 0;
        this.size = size;
    }

    public boolean isFull() {
        if (elementCount == size) {
            return true;
        }

        return false;
    }

    public boolean isEmpty() {
        if (elementCount == 0) {
            return true;
        }

        return false;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(Object value) {
        if (this.isFull()) {
            throw new RuntimeException("Stack is Full");
        }
        //注意这里面试将原来的header作为参数传入，然后以新new出来的Node作为header
        header=new Node(value, header);
        elementCount++;
    }

    /**
     * 出栈
     * @return
     */
    public Object pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        Object object=header.getElement();
        header=header.next;
        elementCount--;
        return object;
    }

    /**
     * 返回栈顶元素
     */
    public Object peak(){

        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return header.getElement();
    }
}
