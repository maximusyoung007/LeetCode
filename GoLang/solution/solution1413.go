package solution

import "math"

func MinStartValue(nums []int) int {
	min, sum := 0, 0
	for _, val := range nums {
		sum += val
		min = int(math.Min(float64(min), float64(sum)))
	}
	return abs(min) + 1
}

func abs(num int) int {
	if num > 0 {
		return num
	}
	return -num
}
