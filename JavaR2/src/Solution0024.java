/**
 * @author maximusyoung
 */
public class Solution0024 {
	public ListNode swapPairs(ListNode head) {
		ListNode res = new ListNode();
		res.next = head;
		ListNode t = res;
		while (t.next != null && t.next.next != null) {
			ListNode t1 = t.next;
			ListNode t2 = t.next.next;
			//交换t1和t2的位置
			t.next = t2;
			t1.next = t2.next;
			t2.next = t1;
			t = t1;
		}
		return res.next;
	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
