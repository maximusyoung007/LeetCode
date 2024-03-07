package solution

// g[n]表示抢到第n家最多，
// 可以抢第n-2家，则g[n]=g[n-2]+nums[n]
// 或者抢第n-1家，则g[n]=g[n-1]
func Rob(nums []int) int {
	g := make([]int, len(nums))

	g[0] = nums[0]

	if len(nums) == 1 {
		return g[0]
	}

	if nums[1] > nums[0] {
		g[1] = nums[1]
	} else {
		g[1] = nums[0]
	}

	for i := 2; i < len(nums); i++ {
		g1 := g[i-2] + nums[i]
		g2 := g[i-1]

		if g1 > g2 {
			g[i] = g1
		} else {
			g[i] = g2
		}
	}
	return g[len(nums)-1]
}
