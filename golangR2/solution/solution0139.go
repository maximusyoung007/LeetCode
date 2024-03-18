package solution

// dp[i]表示以i结尾是否能拆分
func WordBreak(s string, wordDict []string) bool {
	dp := make([]bool, len(s)+1)

	//从第0处分割，肯定是可以分割的
	dp[0] = true

	//当前位置减去单词的长度，如果上一个位置dp[i-len(dict)]可以分割，那么本位置肯定也可以分割
	for i := 1; i <= len(s); i++ {
		for _, dict := range wordDict {
			if i-len(dict) >= 0 && s[i-len(dict):i] == dict {
				dp[i] = dp[i] || dp[i-len(dict)]
				continue
			}
		}
	}

	return dp[len(s)]
}
