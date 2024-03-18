package solution

// dp[i]表示以i结尾的最长递增子序列,依次判断和dp[0],dp[1],dp[2]...dp[i-1]是否能组成递增子序列，选取其中最大值作为dp[i]的值
func LengthOfLIS(nums []int) int {
	dp := make([]int, len(nums))

	res := 1
	dp[0] = 1
	for i := 1; i < len(nums); i++ {
		max := 0
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] && dp[j] > max {
				max = dp[j]
			}
		}
		dp[i] = max + 1
		if dp[i] > res {
			res = dp[i]
		}
	}

	return res
}
