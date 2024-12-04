package solution;

public class Solution0092 {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode t = head;

		ListNode pre = new ListNode(-1);

		int k = 1;

		ListNode last = new ListNode(-1);

		while (t != null) {
			if (k == left - 1) {
				pre = t;
			}

			//left就是需要反转的链表的最后一位
			if (k == left) {
				last = new ListNode(t.val);
				pre.next = last;
			}

			//头插法插入到pre之后
			if (k > left && k <= right) {
				ListNode rt = new ListNode(t.val);
				rt.next = pre.next;
				pre.next = rt;
			}

			//直接把剩下的拼接上即可，不需要遍历
			if (k > right) {
				last.next = t;
				break;
			}

			k++;
			t = t.next;
		}

		if (left == 1) {
			return pre.next;
		} else {
			return head;
		}
	}
}
