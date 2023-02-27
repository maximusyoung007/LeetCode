package solution

// 先遍历奇数位小于左右两边需要变动的值
// 再遍历偶数位小于左右两边需要变动的值
// 取更小的那个
func MovesToMakeZigZag(nums []int) int {
	res := 0
	res1 := 0
	nums1 := make([]int, len(nums))
	copy(nums1, nums)
	for i := 1; i < len(nums1); i++ {
		if i%2 != 0 {
			if i-1 >= 0 {
				for nums1[i] >= nums1[i-1] {
					nums1[i] -= 1
					res++
				}
			}
			if i+1 < len(nums1) {
				for nums1[i] >= nums1[i+1] {
					nums1[i] -= 1
					res++
				}
			}
		}
	}

	for i := 0; i < len(nums); i++ {
		if i%2 == 0 {
			if i-1 >= 0 {
				for nums[i] >= nums[i-1] {
					nums[i] -= 1
					res1++
				}
			}
			if i+1 < len(nums1) {
				for nums[i] >= nums[i+1] {
					nums[i] -= 1
					res1++
				}
			}
		}
	}
	if res < res1 {
		return res
	} else {
		return res1
	}
}
