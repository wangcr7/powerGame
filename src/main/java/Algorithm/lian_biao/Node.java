package Algorithm.lian_biao;

/**
 * @program: CristianoRonaldo
 * @description: 链表节点
 * @author: wang chi
 * @create: 2020-06-15 16:05
 */
public class Node {

    int date;

    Node next;

    public Node(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
