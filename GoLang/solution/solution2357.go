package solution

import "sort"

func minimumOperations(nums []int) int {
	sort.Ints(nums)
	sums := 0
	for _, v := range nums {
		sums += v
	}
	currentMin := 0
	counts := 0
	for sums > 0 {
		for _, v := range nums {
			if v != 0 {
				currentMin = v
				break
			}
		}
		for i := 0; i < len(nums); i++ {
			if nums[i] > 0 {
				nums[i] -= currentMin
				sums -= currentMin
			}
		}
		counts++
	}
	return counts
}
