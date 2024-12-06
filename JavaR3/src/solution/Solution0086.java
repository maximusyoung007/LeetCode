package solution;

public class Solution0086 {
	public ListNode partition(ListNode head, int x) {
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode t = pre;

		//所有需要移动的都拼接到start之后
		boolean hasStart = false;
		ListNode start = new ListNode(-1);

		while (t != null && t.next != null) {
			if (!hasStart && t.next.val >= x) {
				start = t;
				hasStart = true;
			}

			if (hasStart && t.next.val < x) {
				ListNode cur = t.next;
				//删除 需判断是否是最后一个元素
				if (cur.next != null) {
					t.next = cur.next;
                } else {
					t.next = null;
                }
                cur.next = start.next;
                start.next = cur;
                start = start.next;
			} else {
				t = t.next;
			}
		}

		return pre.next;
	}
}
