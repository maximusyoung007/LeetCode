/**
 * dp[n]表示n中有几个1
 * 如果以1结尾，则上一个数一定是以0结尾，则dp[n]=dp[n-1]+1
 * 如果以0结尾，则含有1的个数和右移一位的数相同 dp[n]=dp[n>>1]
 */
public class Solution0338 {
	public int[] countBits(int n) {
		int[] dp = new int[n+1];
		if (n == 0) {
			return dp;
		}
		dp[1] = 1;
		if (n == 1) {
			return dp;
		}
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			//从3开始，奇数以1结尾，偶数以0结尾
			if (i % 2 != 0) {
				dp[i] = dp[i-1] + 1;
			} else {
				dp[i] = dp[i>>1];
			}
		}
		return dp;
	}
}
