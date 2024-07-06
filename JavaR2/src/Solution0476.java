/**
 * 先取反，再与1，则可以得到最后一位，
 * 依次乘2^0, 2^1, 2^2...
 * 再右移
 */
public class Solution0476 {
	public int findComplement(int num) {
		int res = 0;

		int factor = 1;
		while (num > 0) {
			int t = ~num & 1;
			res += t * factor;
			factor *= 2;
			num >>= 1;
		}

		return res;
	}
}
