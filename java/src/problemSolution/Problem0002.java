package problemSolution;

import dataStructure.ListNode;

public class Problem0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1,q = l2,current = head;
        int carry = 0;
        while(p != null || q != null) {
            int a = p == null ? 0 : p.val;
            int b = q == null ? 0 : q.val;
            int sum = a + b + carry;
            if(sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            current.next = node;
            current = current.next;
            if(p != null)
                p = p.next;
            if(q != null)
                q = q.next;
        }
        if(carry > 0)
            current.next = new ListNode(carry);
        return head.next;
    }
}
