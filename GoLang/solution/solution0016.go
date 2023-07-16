package solution

import (
	"fmt"
	"math"
	"sort"
)

func threeSumClosest(nums []int, target int) int {
	sort.Ints(nums)

	minValue, res := math.MaxInt, 0
	for i := 0; i < len(nums); i++ {
		left := i + 1
		right := len(nums) - 1

		for left < right {
			sum := nums[i] + nums[left] + nums[right]
			if sum == target {
				return target
			}

			if sum < target {
				left++
				if target-sum < minValue {
					minValue = target - sum
					res = sum
				}
			}

			if sum > target {
				right--
				if sum-target < minValue {
					minValue = sum - target
					res = sum
				}
			}
		}
	}
	return res
}

func Test0016() {
	nums := []int{-1, 2, 1, 4}
	target := 1
	fmt.Println(threeSumClosest(nums, target))
}
