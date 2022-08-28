package Algorithm.lian_biao;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-06-16 00:37
 */
public class LianBiao {

    public Node first;
    public Node tail;

    public LianBiao(Node first, Node tail) {
        this.first = first;
        this.tail = tail;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}
