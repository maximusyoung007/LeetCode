package solution

func diagonalPrime(nums [][]int) int {
	n := len(nums)
	a, b := 0, 0
	res := 0
	for i := 0; i < n; i++ {
		a = nums[i][i]
		b = nums[i][n-i-1]
		if isPrime6313(a) && a > res {
			res = a
		}
		if isPrime6313(b) && b > res {
			res = b
		}
	}
	return res
}

func isPrime6313(n int) bool {
	if n == 1 || n == 0 {
		return false
	}
	for i := 2; i*i <= n; i++ {
		if n%i == 0 {
			return false
		}
	}
	return true
}
