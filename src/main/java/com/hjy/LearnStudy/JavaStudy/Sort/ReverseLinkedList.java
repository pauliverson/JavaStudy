package com.hjy.LearnStudy.JavaStudy.Sort;

/**
 * @author huangjunyan
 * @date 2019-07-18 20:46
 */
class ListNode {
    ListNode next;
    int val;
    public ListNode(int x) {
        this.val = x;
    }
}
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode cur = l1;
        for(int i = 1;i < 10;i++) {
            cur.next = new ListNode(i+1);
            cur = cur.next;
        }
        cur.next = null;
        cur = l1;
//        while(cur != null) {
//            System.out.println(cur.val);
//            cur = cur.next;
//        }
        cur = reverseList(cur);
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
