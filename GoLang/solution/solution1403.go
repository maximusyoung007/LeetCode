package solution

import "sort"

func MinSubsequence(nums []int) []int {
	sum := 0
	for _, val := range nums {
		sum += val
	}
	n := append([]int{}, nums...)
	sort.Slice(n, func(i, j int) bool {
		return n[i] > n[j]
	})

	sum1 := 0
	for i := 0; i < len(n); i++ {
		sum1 += n[i]
		if sum1 > sum-sum1 {
			return n[0 : i+1]
		}
	}
	return nums
}
