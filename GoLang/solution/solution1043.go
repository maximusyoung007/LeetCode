package solution

/**
dp[i]表示以i结尾的最大值
从i开始往前推，是否需要替换
如1,2,9,10
到10的时候，数组为[9,9,9,10]
第一次循环，数组最大值为10，[9,9,10,10]
第二次循环，数组最大值还是为10，[9,10,10,10]
*/
func MaxSumAfterPartitioning(arr []int, k int) int {
	n := len(arr)
	dp := make([]int, n)
	for i := 0; i < n; i++ {
		maxValue := 0
		for j := i; j >= i-k+1; j-- {
			if i == 0 {
				dp[i] = arr[i]
				break
			}
			if j < 0 {
				break
			}
			if arr[j] > maxValue {
				maxValue = arr[j]
			}
			updateValue := 0
			if j != 0 {
				updateValue = dp[j-1] + (i-j+1)*maxValue
			} else if j == 0 {
				updateValue = (i - j + 1) * maxValue
			}
			if updateValue > dp[i] {
				dp[i] = updateValue
			}
		}
	}
	return dp[n-1]
}
