package solution;

public class Solution0025 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode res = pre;

		ListNode start = head;
		ListNode t = head;

		int tk = k-1;

		while (t != null) {
			if (tk > 0) {
				t = t.next;
				tk--;
			}

			if (tk == 0 && t != null) {
				t = t.next;
				//tail用来保存需要替换的元素的最后一个
				ListNode tail = start;
				start = start.next;
				while (tk != k-1) {
					//用next存start的下一个，因为会被覆盖
					ListNode next = start.next;
					start.next = pre.next;
					pre.next = start;
					start = next;
					tk++;
				}
				tail.next =  t;
				pre = tail;
			}
		}

		return res.next;
	}
}
