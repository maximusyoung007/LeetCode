public class Solution0160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA;
		ListNode b = headB;

		//A长度为a,相交点到末尾长度为c
		//B长度为b, 相交点到末尾长度为c
		//有a + b-c = b + a-c,
		//说明如果有相交点，一个点从A出发，走到结尾后继续走B；一个点从B出发，走到结尾后继续走A；这两个点会刚好在相交点相遇
		while (a != b) {
			a = a != null ? a.next : headB;
			b = b != null ? b.next : headA;
		}

		return a;
	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
