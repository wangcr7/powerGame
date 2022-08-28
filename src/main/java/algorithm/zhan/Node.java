package algorithm.zhan;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-03 23:58
 */
public class Node {

    Object element;
    Node next;

    public Node(Object element){
        this(element,null);
    }

    /**
     * 创建一个新的节点
     * 让他的next指向，参数中的节点
     * @param element
     * @param n
     */
    public Node(Object element,Node n){
        this.element = element;
        next = n;
    }

    public Object getElement() {
        return element;
    }

}
