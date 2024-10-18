package main

func RemoveElement(nums []int, val int) int {
	left, right := 0, 0
	
	//双指针
	//如果右指针指向的值不等于val,则是要保留的，就把这个值放到左指针位置，左右指针+1
	//如果右指针的值等于val，则这个值是要删除的，不往左指针位置放，左指针等待下一个值，不修改，右指针+1
	for right < len(nums) {
		if nums[right] != val {
			nums[left] = nums[right]
			left++
			right++
		} else {
			right++
		}
	}

	return left
}