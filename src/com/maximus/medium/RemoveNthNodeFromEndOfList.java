package com.maximus.medium;

import com.maximus.structure.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFormEnd(ListNode head,int n) {
        //增加一个头节点，用于删除只有一个节点或者删除头节点的情况
        ListNode r = new ListNode(0);
        r.next = head;
        ListNode p1 = r,p2 = r;
        for(int i = 0;i < n;i++) {
            p1 = p1.next;
        }
        while(p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode q = p2.next;
        p2.next = q.next;
        return r.next;
    }
}
