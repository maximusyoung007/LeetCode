package solution;

public class Solution0148 {
	//链表的归并排序
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head, slow = head;
		ListNode preSlow = slow.next;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			preSlow = slow;
			slow = slow.next;
		}

		preSlow.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(slow);

		ListNode res = new ListNode(-1);
		ListNode t = res;
		while (left != null && right != null) {
			if (left.val < right.val) {
				t.next = left;
				left = left.next;
			} else {
				t.next = right;
				right = right.next;
			}
			t = t.next;
		}

		while (left != null) {
			t.next = left;
			left = left.next;
			t = t.next;
		}

		while (right != null) {
			t.next = right;
			right = right.next;
			t = t.next;
		}

		return res.next;
	}
}
