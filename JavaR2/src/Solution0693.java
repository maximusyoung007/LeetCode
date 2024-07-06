/**
 * x&1，可以判断最后一位是1还是0
 * x >> ,右移，可以删除最后一位
 */
public class Solution0693 {
	public boolean hasAlternatingBits(int n) {
		int last = -1;
		while (n > 0) {
			int t = n & 1;
			if (t == last) {
				return false;
			}
			last = t;
			n >>= 1;
		}
		return true;
	}
}
