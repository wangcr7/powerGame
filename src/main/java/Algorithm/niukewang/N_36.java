package Algorithm.niukewang;


/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class N_36 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode h1, h2;
        int count = 0;
        for (h1 = pHead1; h1 != null; h1 = h1.next){
            count++;
        }
        for (h2 = pHead2; h2 != null; h2 = h2.next){
            count--;
        }
        h1 = pHead1;
        h2 = pHead2;

        if (count < 0){
            h1 = pHead2;
            h2 = pHead1;
            count = - count;
        }
        while (count > 0){
            h1 = h1.next;
            count--;
        }
        for (; h1 != h2; h1 = h1.next, h2 = h2.next);
        return h1;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2){

        if (pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode tail = null;
        ListNode h1, h2;
        while (true){
            for (h1 = pHead1; h1.next != tail; h1 = h1.next);
            for (h2 = pHead2; h2.next != tail; h2 = h2.next);
            if (h1 != h2){
                break;
            }
            tail = h1;
        }
        return h1.next;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}


