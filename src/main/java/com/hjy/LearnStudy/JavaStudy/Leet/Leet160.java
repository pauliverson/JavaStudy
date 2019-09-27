package com.hjy.LearnStudy.JavaStudy.Leet;

import com.github.pagehelper.PageInfo;
import com.hjy.LearnStudy.JavaStudy.ListNode;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-26 21:34
 */
public class Leet160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            curA = curA.next;
            lenA ++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB ++;
        }
        curA = headA;
        curB = headB;
        while (lenA > lenB) {
            curA = curA.next;
            lenA--;
        }

        while (lenB > lenA) {
            curB = curB.next;
            lenB--;
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
