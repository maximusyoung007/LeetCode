package solution;

import java.util.Objects;

public class Solution0061 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode fast = head;

		int n = 0;
		while (fast != null) {
			fast = fast.next;
			n++;
		}

		//全量遍历k太慢了
		k = k % n;

		fast = head;
		while (k > 0) {
			fast = fast.next;

			if (fast == null) {
				fast = head;
			}

			k--;
		}

		ListNode slow = head;

		if (fast == slow) {
			return head;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		ListNode res = slow.next;
		slow.next = null;
		fast.next = head;

		return res;

	}

	class Hello {
		private String h1;

		public String getH1() {
			return h1;
		}

		public void setH1(String h1) {
			this.h1 = h1;
		}
	}
	public static void main(String[] args) {
		Hello hello = null;
		Solution0061 solution0061 = new Solution0061();
		solution0061.generateHello();
		System.out.println(Objects.isNull(hello));
	}

	private int generateHello() {
		Hello hello = new Hello();
		hello.setH1("h1");
		return 1;
	}
}
