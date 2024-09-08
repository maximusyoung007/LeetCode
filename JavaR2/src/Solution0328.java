/**
 * @author maximusyoung
 */
public class Solution0328 {
	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode res = new ListNode();
		//res指向偶数节点，奇数节点依次插入偶数节点之前
		res.next = head.next;

		ListNode rt = res;
		boolean first = true;

		while (head != null) {
			ListNode t = head.next;
			if (first) {
				head.next = rt.next;
				rt.next = head;
				rt = rt.next;
				first = false;
			} else {
				if (head.next != null) {
					head.next = head.next.next;
				}
				first = true;
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
