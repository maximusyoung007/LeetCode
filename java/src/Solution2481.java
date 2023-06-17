public class Solution2481 {
	public int numberOfCuts(int n) {
		int res = 0;
		if (n % 2 == 0 || n == 1) {
			res = n / 2;
		} else {
			res = n;
		}
		return res;
	}
}
