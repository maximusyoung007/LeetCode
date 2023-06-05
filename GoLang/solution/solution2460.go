package solution

func ApplyOperations(nums []int) []int {
	n := len(nums)
	res := make([]int, n)
	for i := 0; i < n-1; i++ {
		if nums[i] == nums[i+1] {
			nums[i] = nums[i] * 2
			nums[i+1] = 0
		}
	}
	k := 0
	for i := 0; i < n; i++ {
		if nums[i] != 0 {
			res[k] = nums[i]
			k++
		}
	}
	return res
}
