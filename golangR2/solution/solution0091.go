package solution

/*
*
dp[i]表示以第i位为结尾的最大的解码数
如果第i位为0，如果s[i-1,i]是非法的，则结果为0；如果s[i-1,i]是合法的，则第i位可以在第i-2位的基础上加上i-1，i位，总解码数不变，即dp[i]=dp[i-2]
如果第i位合法，

	s[i-1,i]也合法，则可以在第i-2位的基础上加i-1,i位，也可以在第i-1位的基础上加i位，即dp[i]=dp[i-1]+dp[i-2]
	s[i-1,i]不合法，则可以在第i-1位的基础上加i位，即dp[i]=dp[i-1]
*/
func NumDecodings(s string) int {
	l := len(s)

	dp := make([]int, l+1)

	dp[0] = 1

	if s[0] >= '1' && s[0] <= '9' {
		dp[1] = 1
	} else {
		dp[1] = 0
	}

	for i := 2; i <= l; i++ {
		getDpi(s, dp, i, i-1)
	}
	return dp[l]
}

func getDpi(s string, dp []int, i int, si int) {
	if s[si] == '0' {
		if s[si-1] != '1' && s[si-1] != '2' {
			dp[i] = 0
		} else {
			dp[i] = dp[i-2]
		}
	} else {
		if (s[si-1] == '1' && s[si] <= '9') || (s[si-1] == '2' && s[si] < '7') {
			dp[i] = dp[i-1] + dp[i-2]
		} else {
			dp[i] = dp[i-1]
		}
	}
}
