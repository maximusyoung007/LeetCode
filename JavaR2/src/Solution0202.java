/**
 * 平方和序列会进入一个循环，如 3，9，81，65， 61，37，58， 89， 145，42，20，4，16，37
 * 用快慢指针，如果快指针=快指针，但是这两个指针不等于1，则表示所有的数都已经循环完了，但是没有1，就不是一个快乐数
 * 如果是快乐数的话，快指针一定会比慢指针更快进入1，然后一直等于1，等慢指针到1的时候，两者一定都是1
 */
public class Solution0202 {
	public boolean isHappy(int n) {
		int slow = n, fast = n;
		do {
			slow = calNext(slow);
			fast = calNext(fast);
			fast = calNext(fast);
		} while (slow != fast);

		return slow == 1;
	}

	private static int calNext(int n) {
		int res = 0;
		while (n > 0) {
			int t = n % 10;
			res += t * t;
			n /= 10;
		}
		return res;
	}
}
