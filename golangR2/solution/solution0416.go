package solution

// dp[j]表示前i个数，是否能达到j
// 如果 选第i个数，dp[j] = dp[j] || dp[j-nums[i]]
func CanPartition(nums []int) bool {
	length := len(nums)
	sum := 0
	for i := 0; i < length; i++ {
		sum += nums[i]
	}
	target := sum / 2

	if target*2 != sum {
		return false
	}

	dp := make([]bool, target+1)
	dp[0] = true
	for i := 0; i < length; i++ {
		for j := target; j >= nums[i]; j-- {
			dp[j] = dp[j] || dp[j-nums[i]]
		}
	}

	return dp[target]
}
