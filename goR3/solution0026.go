package main

func RemoveDuplicates(nums []int) int {
    left, right := 0, 0

	for right < len(nums) {
		//判断上一个被保留的数是否相等
		if right > 0 && nums[right] == nums[left-1] {
			right++
		} else {
			nums[left] = nums[right]
			left++
			right++
		}
	}

	return left
}