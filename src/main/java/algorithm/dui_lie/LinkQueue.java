package algorithm.dui_lie;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-04 00:11
 */
public class LinkQueue {

    /**
     * 队头
     */
    private Node head;
    /**
     * 队尾
     */
    private Node tail;

    public LinkQueue() {
        this.head = null;
        this.tail = null;
    }

    public boolean inQueue(int data) {

        Node p = new Node(data);
        if (head == null) {
            head = p;
            tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
        return true;
    }

    public int outQueue() {

        if (head == null) {
            return 0;
        } else {
            int t = head.getData();
            head = head.next;
            return t;
        }
    }

    public int peek() {
        if(head == null) {
            return 0;
        } else {
            return head.getData();

        }
    }
    //判空
    public boolean isEmpty() {
        return head == null;
    }
}
