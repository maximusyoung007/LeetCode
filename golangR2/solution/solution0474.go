package solution

// dp[i][j]表示i个0，j个1能组成的最大数量
// 遍历strs中的每一个str,假设str中有count0个0，count1个1，则dp[i][j]=
func FindMaxForm(strs []string, m int, n int) int {
	dp := make([][]int, m+1)
	for i := 0; i <= m; i++ {
		dp[i] = make([]int, n+1)
	}

	for _, str := range strs {
		count0, count1 := 0, 0
		for c := 0; c < len(str); c++ {
			if str[c] == '0' {
				count0++
			} else if str[c] == '1' {
				count1++
			}
		}
		for i := m; i >= count0; i-- {
			for j := n; j >= count1; j-- {
				if dp[i-count0][j-count1]+1 > dp[i][j] {
					dp[i][j] = dp[i-count0][j-count1] + 1
				}
			}
		}
	}
	return dp[m][n]
}
