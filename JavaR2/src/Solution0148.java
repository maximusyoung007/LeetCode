public class Solution0148 {
	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		return mergeSort(head);
	}

	public ListNode mergeSort(ListNode head) {
		//如果递归到单个节点，则返回
		if (head.next == null) {
			return head;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next;

		slow.next = null;

		ListNode r1 = mergeSort(head);
		ListNode r2 = mergeSort(mid);

		//将子链表排序的结果返回
		ListNode res = merge(r1, r2);
		return res;
	}

	public ListNode merge(ListNode node1, ListNode node2) {
		ListNode res = new ListNode();
		ListNode rt = res;

		while (node1 != null && node2 != null) {
			if (node1.val <= node2.val) {
				ListNode t = node1.next;
				node1.next = rt.next;
				rt.next = node1;
				node1 = t;
			} else {
				ListNode t = node2.next;
				node2.next = rt.next;
				rt.next = node2;
				node2 = t;
			}
			rt = rt.next;
		}

		while (node1 != null) {
			ListNode t = node1.next;
			node1.next = rt.next;
			rt.next = node1;
			node1 = t;
			rt = rt.next;
		}

		while (node2 != null) {
			ListNode t = node2.next;
			node2.next = rt.next;
			rt.next = node2;
			node2 = t;
			rt = rt.next;
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
