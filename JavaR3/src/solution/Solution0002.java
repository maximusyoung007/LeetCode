package solution;

/**
 * @author maximusyoung
 */
public class Solution0002 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(-1);
		ListNode cur = res;

		int rest = 0;
		while (l1 != null && l2 != null) {
			int t = l1.val + l2.val + rest;
			if (t >= 10) {
				t = t % 10;
				rest = 1;
			} else {
				rest = 0;
			}

			cur.next = new ListNode(t);
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int t = l1.val + rest;
			if (t >= 10) {
				t = t % 10;
				rest = 1;
			} else {
				rest = 0;
			}

			cur.next = new ListNode(t);
			cur = cur.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			int t = l2.val + rest;
			if (t >= 10) {
				t = t % 10;
				rest = 1;
			} else {
				rest = 0;
			}

			cur.next = new ListNode(t);
			cur = cur.next;
			l2 = l2.next;
		}

		if (rest == 1) {
			cur.next = new ListNode(1);
		}

		return res.next;
	}
}
