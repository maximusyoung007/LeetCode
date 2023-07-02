package solution

import "fmt"

func longestAlternatingSubarray(nums []int, threshold int) int {
	res := 0
	for i := 0; i < len(nums); i++ {
		for j := i; j < len(nums); j++ {
			if j-i+1 > res && nums[i]%2 == 0 {
				if isAlternating(i, j, nums, threshold) {
					res = j - i + 1
				}
			}
		}
	}
	return res
}

func isAlternating(i int, j int, nums []int, threshold int) bool {
	for k := i; k <= j; k++ {
		if k+1 <= j && nums[k]%2 == nums[k+1]%2 {
			return false
		}

		if nums[k] > threshold {
			return false
		}
	}
	return true
}

func Testwc35201() {
	//nums := []int{3, 2, 5, 4}
	//threshold := 5
	//nums := []int{1, 2}
	//threshold := 2
	nums := []int{2, 3, 4, 5}
	threshold := 4
	fmt.Println(longestAlternatingSubarray(nums, threshold))
}
