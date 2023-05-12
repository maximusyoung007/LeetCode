package solution

/**
dp[i]表示将正整数i拆分后，这些整数的最大乘积
dp[0]=0, dp[1]=1
i 从1到n遍历
取j,剩下的数为i-j
如果i-j继续拆分，乘积为j*dp[i-j]
如果i-j不再继续拆分，乘积为j*(i-j)
dp[i]取这些乘积的最大值
*/
func IntegerBreak(n int) int {
	dp := make([]int, n+1)
	dp[1] = 1
	for i := 2; i <= n; i++ {
		for j := 1; j <= i; j++ {
			t := 0
			if j*(i-j) > j*dp[i-j] {
				t = j * (i - j)
			} else {
				t = j * dp[i-j]
			}
			if t > dp[i] {
				dp[i] = t
			}
		}
	}
	return dp[n]
}
