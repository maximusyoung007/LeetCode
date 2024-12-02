package solution;

/**
 * @author maximusyoung
 */
public class Solution0021 {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode head = new ListNode(-1);
		ListNode t = head;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				t.next = list1;
				list1 = list1.next;
			} else {
				t.next = list2;
				list2 = list2.next;
			}
			t = t.next;
		}

		while (list1 != null) {
			t.next = list1;
			list1 = list1.next;
			t = t.next;
		}

		while (list2 != null) {
			t.next = list2;
			list2 = list2.next;
			t = t.next;
		}

		return head.next;
	}
}
