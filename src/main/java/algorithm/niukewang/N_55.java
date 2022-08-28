package algorithm.niukewang;

/**
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class N_55 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode i,j;
        if (pHead.next == pHead){
            return pHead;
        }

        for ( i = pHead.next; i != null ; i = i.next) {

            for (j  = pHead; i != j && i.next != j; j = j.next);

            if (i != j){
                return j;
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
