package main

// MajorityElement 投票法，候选人初始化为nums[0], count为候选人票数，
// 相同的+1，不同的-1，因为多数票数量大于n/2, 非多数票小于n/2,
// 因此全部相减完，多数票还有剩余，剩余的即为结果
func MajorityElement(nums []int) int {
	res := nums[0]
	count := 1

	for i := 1; i < len(nums); i++ {
		if nums[i] == res {
			count++
		} else {
			count--
			if count == 0 {
				res = nums[i]
				count = 1
			}
		}
	}

	return res
}
