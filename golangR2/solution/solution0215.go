package solution

func FindKthLargest(nums []int, k int) int {
	return quickSort(nums, 0, len(nums)-1, k)
}

func quickSort(nums []int, left int, right int, k int) int {
	i, j := left, right

	mid := (left + right) / 2
	nums[left], nums[mid] = nums[mid], nums[left]

	base := nums[i]
	for i < j {
		for i < j && nums[j] <= base {
			j--
		}
		nums[i] = nums[j]

		for i < j && nums[i] >= base {
			i++
		}
		nums[j] = nums[i]
	}
	nums[i] = base

	if i == k-1 {
		return nums[i]
	} else if i > k-1 {
		return quickSort(nums, left, i, k)
	} else {
		return quickSort(nums, i+1, right, k)
	}
}
