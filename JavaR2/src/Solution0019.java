/**
 * @author maximusyoung
 * 两个指针，一个指针先走n步，慢指针启动，然后走N-n步，这是慢指针也走了N-n步，距离结尾距离为n
 */
public class Solution0019 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode res = new ListNode();
		res.next = head;
		ListNode fast = res, slow = res;
		while (n > 0) {
			fast = fast.next;
			n--;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		//slow的下一个节点就是要删除的节点
		slow.next = slow.next.next;

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
