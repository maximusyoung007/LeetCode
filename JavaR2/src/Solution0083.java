public class Solution0083 {
	public ListNode deleteDuplicates(ListNode head) {
		//如果val范围极大，需要加个标志位确认一下是否是第一个节点
		ListNode res = new ListNode(-200);
		ListNode rt = res;
		while (head != null) {
			ListNode t = head.next;

			if (rt.val != head.val) {
				head.next = rt.next;
				rt.next = head;
				rt = rt.next;
			}
			head = t;
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
