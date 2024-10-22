package main

func Rotate(nums []int, k int) {
	t := 0

	for k > 0 {
		t = nums[len(nums)-1]
		for i := len(nums) - 1; i >= 1; i-- {
			nums[i] = nums[i-1]
		}
		nums[0] = t
		k--
	}
}
