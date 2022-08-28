package leetcode;

/**
 * @Title: ListNode
 * @Package: leetcode
 * @Description: 通用链表
 * @Author: wangchi
 * @Date: 2022/8/28 - 4:10 PM
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
