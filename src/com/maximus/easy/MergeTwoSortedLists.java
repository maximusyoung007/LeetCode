package com.maximus.easy;

import com.maximus.structure.ListNode;

//尾插头删
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pre = result;
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);
        p1.next = l1;
        p2.next = l2;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                //删除l1
                p1.next = l1.next;
                //将l1赋给q1，加到result上
                ListNode q1 = l1;
                pre.next = q1;
                pre = q1;
                l1 = l1.next;
            }
            else if(l1.val > l2.val) {
                p2.next = l2.next;
                ListNode q2 = l2;
                pre.next = q2;
                pre = q2;
                l2 = l2.next;
            }
        }
        if(l1 != null) pre.next = l1;
        if(l2 != null) pre.next = l2;
        return result.next;
    }
}
