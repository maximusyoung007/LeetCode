package main

// TrapColumn 按列求，先取每个位置左边最高的高度，再取每个位置右边最高的高度，取其中的最小值
// 每个位置与最小值的差值即为可以盛水的高度
// 动态规划，左边最大的是max{max, height[i]}
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

	for i := n - 1; i >= 0; i-- {
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

// TrapTwoPoints 双指针
// 要找到每个位置左边最大的和右边最大的两个值中更小的那个值
// lmax,rmax记录每个位置左边和右边最大的值
// 两个指针，一个从左往右遍历，一个从右往左遍历，刚好可以取到左右最大值更小的那个，更新相关值并移动指针
// 如果遍历到的元素大于左右最大值，则更新
func TrapTwoPoints(height []int) int {
	n := len(height)
	leftMax, rightMax := -1, -1
	left, right := 0, n-1
	res := 0
	for left < right {
		if height[left] < height[right] {
			if height[left] > leftMax {
				leftMax = height[left]
			} else {
				res += leftMax - height[left]
			}
			left++
		} else {
			if height[right] > rightMax {
				rightMax = height[right]
			} else {
				res += rightMax - height[right]
			}
			right--
		}
	}

	return res
}

func TrapMonotonicStack(height []int) int {
	//维护一个单调递减栈
	//如果小于栈顶，则直接入栈
	//如果大于栈顶，则出栈cur，l为出栈后的栈顶，比较cur和l，如果栈顶大于cur,则表示可以接雨水，
	//r为现在遍历到的位置，取l和r中较小的那个，与出栈cur相减，计算 (min(l,r)-cur)*(r-l-1)

	n := len(height)
	stack := make([]int, 0)

	stack = append(stack, 0)

	res := 0
	for i := 1; i < n; i++ {
		for len(stack) > 0 && height[i] > height[stack[len(stack)-1]] {
			cur := stack[len(stack)-1]
			stack = stack[0 : len(stack)-1]
			if len(stack) <= 0 {
				break
			}
			l := stack[len(stack)-1]

			min := 0

			//可以盛雨水
			if height[l] > height[cur] {

				if height[l] < height[i] {
					min = l
				} else {
					min = i
				}
				res += (height[min] - height[cur]) * (i - l - 1)
			}

		}

		stack = append(stack, i)
	}
	return res
}
