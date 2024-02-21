package solution

import "math"

func JudgeSquareSum(c int) bool {
	right := int(math.Sqrt(float64(c)))
	left := 0

	for left <= right {
		r := left*left + right*right
		if r > c {
			right--
		} else if r < c {
			left++
		} else {
			break
		}
	}

	if left > right {
		return false
	}
	return true
}
