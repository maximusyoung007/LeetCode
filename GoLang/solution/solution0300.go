package solution

import "math"

func LengthOfLIS(nums []int) int {
	n := len(nums)
	dp := make([]int, n)
	maxn := math.MinInt8
	for i := 0; i < n; i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if nums[j] < nums[i] {
				if dp[j]+1 >= dp[i] {
					dp[i] = dp[j] + 1
				}
			}
		}
		if dp[i] > maxn {
			maxn = dp[i]
		}
	}
	return maxn
}
