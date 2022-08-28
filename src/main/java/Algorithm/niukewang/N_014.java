package Algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 输入一个链表，输出该链表中倒数第k个结点。
 * @author: wang chi
 * @create: 2020-06-18 16:31
 */
public class N_014 {

    public ListNode FindKthToTail(ListNode head,int k) {

        ListNode Pend = null;
        ListNode first;
        int count = 0;
        while (head != Pend){
            for (first = head;first.next != Pend;first = first.next);
            Pend = first;
            count ++;
            if (count == k){
                return Pend;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


