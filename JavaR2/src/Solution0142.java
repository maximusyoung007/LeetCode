/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/20      create
 */

class ListNode {
	int val;
 	ListNode next;
 	ListNode(int x) {
 		val = x;
	  	next = null;
 	}
}

/**
 * 设共有a+b个节点，进环之前a个几点，环内b个节点
 * 设两个节点，一个一次走一个节点，为s;一个一次走两个节点，为f
 * f走过的路是s的两倍，即f=2s
 * f与s重合时，刚好比s多走过圈的n倍，f=s+nb
 * 2s=s+nb => s=nb，即s刚好走了n圈，但是这个n圈里，有一部分是a,所以要再走a步才能走到环起点
 * 将fast指向head, 每次走1步，走a步，此时f会和s在环起点相遇
 */
public class Solution0142 {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow = head;

		while (true) {
			if (fast == null || fast.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}

		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}
