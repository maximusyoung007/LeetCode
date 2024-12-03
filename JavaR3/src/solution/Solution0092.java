package solution;

public class Solution0092 {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode t = head;

		ListNode newHead = new ListNode(-1);
		ListNode newT = newHead;

		int k = 1;
		
		while (t != null) {
			if (k <= left || k > right) {
				newT.next = t;
				newT = newT.next;
			} else {
				ListNode tt = new ListNode(t.val);
				tt.next = newHead.next;
				newHead.next = tt;
			}
			k++;
			t = t.next;
		}

		return newHead.next;
	}
}
