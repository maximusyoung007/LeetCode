package solution

func CountNumbersWithUniqueDigits(n int) int {
	if n == 0 {
		return 1
	}
	res := 10
	if n == 1 {
		res = 10
	}
	cur := 9
	for i := 0; i < n-1; i++ {
		cur *= 9 - i
		res += cur
	}
	return res
}
