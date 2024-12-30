package solution;

public class Solution0023 {
	public ListNode mergeKLists(ListNode[] lists) {
		return merge(0, lists.length - 1, lists);
	}

	public ListNode merge(int left, int right, ListNode[] lists) {
		if (left > right) {
			return null;
		}
		if (left == right) {
			return lists[left];
		}

		int mid = (left + right) / 2;

		ListNode node1 = merge(left, mid, lists);
		ListNode node2 = merge(mid+1, right, lists);

		ListNode th = new ListNode(-1);

		ListNode t = th;
		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				t.next = node1;
				node1 = node1.next;
			} else {
				t.next = node2;
				node2 = node2.next;
			}
			t = t.next;
		}

		while (node1 != null) {
			t.next = node1;
			node1 = node1.next;
			t = t.next;
		}

		while (node2 != null) {
			t.next = node2;
			node2 = node2.next;
			t = t.next;
		}

		return th.next;
	}

}
