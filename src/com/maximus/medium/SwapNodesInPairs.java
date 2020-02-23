package com.maximus.medium;

import com.maximus.structure.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        if(head == null)
            return preHead.next;
        preHead.next = head;
        ListNode pre = preHead;
        ListNode p = head;
        ListNode p2 = head.next;
        while(p != null && p.next != null) {
            //将p放到p2后面
            pre.next = p2;
            p.next = p2.next;
            p2.next = p;
            //确定p不是最后一位，避免空指针异常,重新定位pre p p2
            if(p.next != null) {
                pre = p;
                p = p.next;
                p2 = p.next;
            }
        }
        return preHead.next;
    }
}