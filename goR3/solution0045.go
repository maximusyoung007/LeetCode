package main

import (
	"math"
)

func Jump(nums []int) int {
	n := len(nums)

	if n == 1 {
		return 0
	}

	if n == 2 {
		return 1
	}

	//minStep记录到每个位置的最小步数，从每个位置出发，重置到从当前位置所能到达位置的步数
	minStep := make([]int, n)
	minStep[0] = 0
	minStep[1] = 1
	for i := 2; i < n; i++ {
		minStep[i] = math.MaxInt
	}

	for i := 0; i < n; i++ {
		j := 1
		for j <= nums[i] {
			if i+j < n && minStep[i+j] > minStep[i]+1 {
				minStep[i+j] = minStep[i] + 1
			}
			j++
		}
	}

	return minStep[n-1]
}
