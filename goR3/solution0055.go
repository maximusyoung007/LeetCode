package main

func CanJump(nums []int) bool {
	//step[i]表示在第i个位置，最远还可以往后跳几步
	//任意一步如果小于等于0，就跳不到最后一个了
	n := len(nums)
	step := make([]int, n)

	for i := 0; i < n; i++ {
		if i == 0 {
			step[i] = nums[i]
		} else if i == n-1 {
			step[i] = step[i-1] - 1
		} else {
			if nums[i] >= step[i-1] {
				step[i] = nums[i]
			} else {
				step[i] = step[i-1] - 1
			}
		}

		if i != n-1 && step[i] == 0 {
			return false
		}
	}

	return true
}
