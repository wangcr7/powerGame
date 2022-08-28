package Algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author: wang chi
 * @create: 2020-06-29 17:43
 */
public class N_025_1 {

    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null){
            return null;
        }
        RandomListNode current = pHead;
        while (current != null){
            RandomListNode cloneNode = new RandomListNode(current.label);
            RandomListNode nextNode = current.next;
            current.next = cloneNode;
            cloneNode.next = nextNode;
            current = nextNode;
        }
        current = pHead;
        while (current != null){
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next.next;
        }
        current = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (current != null){

            RandomListNode cloneNode = current.next;
            current.next = current.next.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            current = current.next;
        }

        return pCloneHead;
    }

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
