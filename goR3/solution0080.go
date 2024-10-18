package main

func RemoveDuplicates2(nums []int) int {
    left, right := 0, 0

	for right < len(nums) {
		//检查上两个保留的数是否相等
		if right > 1 && nums[right] == nums[left - 2] {
			right++
		} else {
			nums[left] = nums[right]
			left++
			right++
		}
	}

	return left
}