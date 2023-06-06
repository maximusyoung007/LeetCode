package solution

import "sort"

//先确定结果可能的范围，再通过二分查找判断当前值是否合理
func SmallestDivisor(nums []int, threshold int) int {
	sort.Ints(nums)
	left, right := 0, nums[len(nums)-1]
	for left < right {
		mid := (left + right + 1) / 2
		if isLegal(threshold, mid, nums) {
			right = mid - 1
		} else {
			left = mid
		}
	}
	return left + 1
}

func isLegal(threshold int, mid int, nums []int) bool {
	sum := 0
	for _, v := range nums {
		if v%mid == 0 {
			sum += v / mid
		} else {
			sum += v/mid + 1
		}
		if sum > threshold {
			return false
		}
	}
	if sum <= threshold {
		return true
	}
	return false
}
