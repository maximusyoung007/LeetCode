package solution

func MaxDivScore(nums []int, divisors []int) int {
	res, count := -1, -1
	for _, v := range divisors {
		c := 0
		for _, num := range nums {
			if num%v == 0 {
				c++
			}
		}
		if c > count {
			count = c
			res = v
		}
		if c == count {
			if v < res {
				res = v
			}
		}
	}
	return res
}
