/**
 * @author maximusyoung
 * 0,1,2
 * 0,1,2,3
 * 1 2 0 2 1
 */
public class Solution0234 {

	public boolean isPalindrome(ListNode head) {
		//快慢指针找中间节点
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next;
		ListNode second = new ListNode();
		while (mid != null) {
			ListNode t = mid.next;
			mid.next = second.next;
			second.next = mid;
			mid = t;
		}

		ListNode secondHead = second.next;
		while (head != null && secondHead != null) {
			if (head.val != secondHead.val) {
				return false;
			}
			head = head.next;
			secondHead = secondHead.next;
		}

		return true;
	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
