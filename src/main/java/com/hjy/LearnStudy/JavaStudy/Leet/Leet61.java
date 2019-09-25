package com.hjy.LearnStudy.JavaStudy.Leet;

import com.didi.mybatis.demo.JavaStudy.ListNode;

import java.util.Stack;

/**
 * @author huangjunyan
 * @program test
 * @description LeetCode61
 * @date 2019-08-21 00:41
 */
public class Leet61 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 8; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }

        ListNode res = rotateRightByCircle(cur, 10);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode rotateRightByStack(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        ListNode pre = head;
        k = k % length;
        int gap = length - k - 1;
        while (gap >= 1) {
            pre = pre.next;
            gap--;
        }

        Stack<ListNode> stack = new Stack<>();
        while (pre.next != null) {
            cur = pre.next;
            pre.next = cur.next;
            cur.next = null;
            stack.push(cur);
        }
        stack.forEach((node) -> {
            System.out.println(node.val);
        });
        cur = head;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = cur;
            cur = node;
        }
        return cur;
    }
    public static ListNode rotateRightByCircle(ListNode head, int k) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        int n;

        ListNode oldTail = head;
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;
        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            newTail = newTail.next;
        }
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}
