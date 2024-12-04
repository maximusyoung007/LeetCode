package solution;

public class Solution0019 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		//快慢指针，快指针先移动n次，然后快慢指针一起移动，快指针到末尾时，删除慢指针
		ListNode fast = head, slow = head;

		while (n > 0) {
			fast = fast.next;
			n--;
		}

		//如果fast==null，表示删除的是第一位
		if (fast == null) {
			return head.next;
		}

		//遍历到slow前一位，则可以删除slow
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return head;
	}
}
