package solution;

public class Solution0082 {
	//pre 1 2 3 3 4 5
	public ListNode deleteDuplicates(ListNode head) {
		ListNode pre = new ListNode(-1);
		pre.next = head;

		ListNode t = pre;

		ListNode start = t;
		int count = 0;
		while (t.next != null) {
			if (t.val != t.next.val) {
				if (count > 1) {
					start.next = t.next;
					//start后面重复的都删除了，所以起点还是start
					//start = t;
				} else {
					start = t;
				}
				count = 1;
			} else {
				count++;
			}
			t = t.next;
		}

		//如果遍历完了count还大于1，说明末尾有重复的
		if (count > 1) {
			start.next = null;
		}

		return pre.next;
	}
}
