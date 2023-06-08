package solution

import "sort"

func MaximumCandies(candies []int, k int64) int {
	sort.Ints(candies)
	var left, right int64
	left, right = 0, int64(candies[len(candies)-1])
	for left < right {
		mid := (left + right + 1) / 2
		if canShare(candies, mid, k) {
			left = mid
		} else {
			right = mid - 1
		}
	}
	return int(left)
}

//假设每个孩子可以拿走s颗，从第一堆开始遍历，判断能分出几堆s颗（即可以满足几个孩子）,判断分出的总数是否大于等于k，
func canShare(candies []int, s int64, k int64) bool {
	var sum int64
	for _, v := range candies {
		sum += int64(v) / s
		if sum >= k {
			return true
		}
	}
	return sum >= k
}
