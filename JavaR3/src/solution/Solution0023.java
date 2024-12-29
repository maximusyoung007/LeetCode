package solution;

public class Solution0023 {
	public ListNode mergeKLists(ListNode[] lists) {

	}

	public ListNode merge(int left, int right, ListNode[] lists) {
		if (left == right) {
			return lists[left];
		}

		if (left == right-1) {
			ListNode node1 = lists[left];
			ListNode node2 = lists[right];

			ListNode th = new ListNode(-1);

			ListNode t = th;
			while (node1 != null && node2 != null) {
				if (node1.val < node2.val) {
					t.next = node1;
				} else {
					t.next = node2;
				}
				t = t.next;
			}


		}
	}
}
