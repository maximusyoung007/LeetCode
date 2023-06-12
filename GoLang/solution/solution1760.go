package solution

import "sort"

func MinimumSize(nums []int, maxOperations int) int {
	sort.Ints(nums)
	left, right := 0, nums[len(nums)-1]
	for left < right {
		k := (left + right + 1) / 2
		if checkPenalty(nums, maxOperations, k) {
			right = k - 1
		} else {
			left = k
		}
	}
	return right + 1
}

func checkPenalty(nums []int, maxOperations int, k int) bool {
	sum := 0
	for _, v := range nums {
		sum += (v - 1) / k
	}
	//不用maxOperation次就可以分出，说明k过大
	return sum <= maxOperations
}
