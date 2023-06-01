package solution

import "sort"

/*
piles排序
left = 0
注意有条件 h < len(piles), 因此二分查找时，right=pile[len-1]
满足条件的最小时间t在left和right之间
遍历piles,如果以t的速度吃香蕉，总耗时低于h，则合法，继续向左二分
*/

func MinEatingSpeed(piles []int, h int) int {
	sort.Ints(piles)
	n := len(piles)
	left, right := 0, piles[n-1]
	for left < right {
		t := (left + right + 1) / 2
		if check(piles, h, t) {
			right = t - 1
		} else {
			left = t
		}
	}
	return left + 1
}

func check(piles []int, h int, t int) bool {
	sum := 0
	for _, pile := range piles {
		if pile%t == 0 {
			sum += pile / t
		} else {
			sum += pile/t + 1
		}
	}
	return sum <= h
}
