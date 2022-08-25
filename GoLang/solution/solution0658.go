package solution

import (
	"math"
	"sort"
)

func FindClosestElements(arr []int, k int, x int) []int {
	res := make([]int, 0)
	var index int
	sum := math.MaxInt
	for i := 0; i < len(arr); i++ {
		if math.Abs(float64(arr[i] - x)) < float64(sum) {
			sum = int(math.Abs(float64(arr[i] - x)))
			index = i
		}
	}

	left := index
	right := index + 1

	num := 0
	for left >= 0 || right < len(arr) {
		if left >= 0 && right < len(arr) {
			if math.Abs(float64(arr[left]-x)) > math.Abs(float64(arr[right]-x)) {
				res = append(res, arr[right])
				right++
			} else {
				res = append(res, arr[left])
				left--
			}
		} else if left >= 0 {
			res = append(res, arr[left])
			left--
		} else if right < len(arr) {
			res = append(res, arr[right])
			right++
		}
		num++
		if num == k {
			break
		}
	}
	sort.Ints(res)
	return res
}