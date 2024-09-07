public class Solution0206 {
	/**
	 * 新建一个结果链表节点，原链表头插法
	 */
	public ListNode reverseList(ListNode head) {
		ListNode res = new ListNode();
		while (head != null) {
			ListNode t = head.next;
			head.next = res.next;
			res.next = head;
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
