package main

//按列求，先取每个位置左边最高的高度，再取每个位置右边最高的高度，取其中的最小值
//每个位置与最小值的差值即为可以盛水的高度
//动态规划，左边最大的是max{max, height[i]}
func TrapColumn(height []int) int {
	res := 0
	n := len(height)
	max := -1

	leftHeight := make([]int, n)
	rightHeight := make([]int, n)

	for i := 0; i < n; i++ {
		if max > height[i] {
			leftHeight[i] = max
		}
		if height[i] > max {
			max = height[i]
		}
	}

	max = -1

	for i := n-1; i >= 0; i-- {
		if max > height[i] {
			rightHeight[i] = max
		}
		if height[i] > max {
			max = height[i]
		}
	}

	min := 0
	for i := 0; i < n; i++ {
		if leftHeight[i] < rightHeight[i] {
			min = leftHeight[i]
		} else {
			min = rightHeight[i]
		}
		if min != 0 {
			res += min - height[i]
		}
	}

	return res
}

//双指针
//要找到每个位置左边最大的和右边最大的两个值中更小的那个值
//lmax,rmax记录每个位置左边和右边最大的值
//两个指针，一个从左往右遍历，一个从右往左遍历，刚好可以取到左右最大值更小的那个，更新相关值并移动指针
//如果遍历到的元素大于左右最大值，则更新
func TrapTwoPoints(height[] int) {

}