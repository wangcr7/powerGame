package Algorithm.dui_lie;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-04 00:11
 */
public class Node {

    /**
     * 数据域
     */
    int data;

    /**
     * 引用
     */
    Node next;

    public Node()
    {
        this.data = 0;
        this.next = null;
    }
    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
    public void setNext(Node t)
    {
        this.next=t;
    }
    public int getData()
    {
        return this.data;
    }
    public Node getNext()
    {
        return this.next;
    }


}
