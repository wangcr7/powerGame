package Algorithm.niukewang;

import java.util.ArrayList;

/**
 * @program: CristianoRonaldo
 * @description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @author: wang chi
 * @create: 2020-06-17 01:47
 */
public class N_003 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode == null){
            return new ArrayList(0);
        }
        ListNode hn = null;
        ListNode h = listNode;
        ListNode current = listNode;
        while (h != null){
            h = h.next;
            current.next = hn;
            hn = current;
            current = h;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (;hn != null;hn = hn.next){
            list.add(hn.val);
        }
        return list;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}

