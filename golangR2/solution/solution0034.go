package solution

// 因为nums是有序的，所以其实就是找第一个等于target和第一个大于target的
func SearchRange(nums []int, target int) []int {
	start := findTarget(nums, target, true)
	var end int
	if start == -1 {
		//如果start为-1,表示没有找到，则end一定也为-1
		end = -1
	} else {
		end = findTarget(nums, target, false) - 1
	}
	return []int{start, end}
}

func findTarget(nums []int, target int, findEqual bool) int {
	left, right := 0, len(nums)
	var res = -1
	for left < right {
		mid := (left + right) / 2
		if findEqual {
			if nums[mid] >= target {
				right -= 1
				if nums[mid] == target {
					res = mid
				}
			} else {
				left += 1
			}
		} else {
			if nums[mid] > target {
				right -= 1
				res = mid
			} else {
				left += 1
			}
		}
	}
	return res
}
