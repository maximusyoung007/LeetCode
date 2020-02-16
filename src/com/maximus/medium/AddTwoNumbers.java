package com.maximus.medium;

import com.maximus.structure.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        ListNode current = result;
        while(p != null || q != null) {
            int p1 = p != null ? p.val : 0;
            int q1 = q != null ? q.val : 0;
            int r1 = p1 + q1 + carry;
            carry = r1 / 10;
            r1 = r1 % 10;
            current.next = new ListNode(r1);
            current = current.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0)
            current.next = new ListNode(carry);
        return result.next;
    }
}
