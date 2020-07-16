package problemSolution;

import dataStructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem0002Test {

    @Test
    public void addTwoNumbers() {
        Problem0002 problem0002 = new Problem0002();
        ListNode l1 = new ListNode(1);
        ListNode l2= new ListNode(8);
        l1.next = l2;

        ListNode n1 = new ListNode(0);

        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(8);
        r1.next = r2;

        ListNode r = problem0002.addTwoNumbers(l1,n1);
        ListNode rr = r.next;
        System.out.println(r.val + "-------" + rr.val);
        //assertEquals(r1,problem0002.addTwoNumbers(l1,n1));
    }
}