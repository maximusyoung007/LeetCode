package solution

// MaxSumTwoNoOverlap
// 先假设firstLen在前，secondLen在后，求前缀值
// 再假设firstLen在后，secondLen在前，求前缀值
func MaxSumTwoNoOverlap(nums []int, firstLen int, secondLen int) int {
	n := len(nums)
	preSum := make([]int, n+1)
	sum := 0
	for i := 0; i <= n; i++ {
		preSum[i] = sum
		if i != n {
			sum += nums[i]
		}
	}
	res := 0
	maxSumLeft, maxSumRight := 0, 0
	sumLeft, sumRight := 0, 0
	for i := 0; i+firstLen <= n; i++ {
		endI := i + firstLen
		sumLeft = preSum[endI] - preSum[i]
		if sumLeft > maxSumLeft {
			maxSumLeft = sumLeft
		}
		for j := endI; j+secondLen <= n; j++ {
			endJ := j + secondLen
			sumRight = preSum[endJ] - preSum[j]
			if sumRight > maxSumRight {
				maxSumRight = sumRight
			}
		}
		if maxSumLeft+maxSumRight > res {
			res = maxSumLeft + maxSumRight
		}
		maxSumLeft = 0
		maxSumRight = 0
	}
	for i := 0; i+secondLen <= n; i++ {
		endI := i + secondLen
		sumLeft = preSum[endI] - preSum[i]
		if sumLeft > maxSumLeft {
			maxSumLeft = sumLeft
		}
		for j := endI; j+firstLen <= n; j++ {
			endJ := j + firstLen
			sumRight = preSum[endJ] - preSum[j]
			if sumRight > maxSumRight {
				maxSumRight = sumRight
			}
		}
		if maxSumLeft+maxSumRight > res {
			res = maxSumLeft + maxSumRight
		}
		maxSumLeft = 0
		maxSumRight = 0
	}
	return res
}
