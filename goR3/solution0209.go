package main

import "math"

func MinSubArrayLen(target int, nums []int) int {
	//维护一个滑动数组
	i, j := 0, 0

	t := 0
	res := math.MaxInt
	for j < len(nums) {
		t += nums[j]

		for t >= target && i <= j {
			if j-i+1 < res {
				res = j - i + 1
			}
			t = t - nums[i]
			i++
		}
		j++
	}

	if res == math.MaxInt {
		res = 0
	}

	return res
}
