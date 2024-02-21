package solution

func MySqrt(x int) int {
	left, right := 1, x
	mid := (left + right) / 2
	for left < right {
		mid = (left + right) / 2
		if mid*mid == x {
			break
		} else if mid*mid > x {
			right = mid
		} else if mid*mid < x {
			left = mid + 1
		}
	}
	if mid*mid > x {
		return mid - 1
	}
	return mid
}
