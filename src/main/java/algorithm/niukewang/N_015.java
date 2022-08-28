package algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-06-18 16:42
 */
public class N_015 {

    public ListNode ReverseList(ListNode head) {

        ListNode h = head;
        ListNode hn = null;
        while (h != null){
            ListNode p = h;
            h = h.next;
            p.next = hn;
            hn = p;
        }
        return hn;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


