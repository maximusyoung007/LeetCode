package solution

import "strconv"

/**
不断短除
如果当前n是负数并且不能除尽，则向上取整
*/
func BaseNeg2(n int) string {
	s := ""
	if n == 0 {
		return "0"
	}
	for n != 1 {
		if n > 0 {
			c := strconv.Itoa(n % (-2))
			s = c + s
			n = n / (-2)
		} else {
			lastN := n
			if n%(-2) == 0 {
				n = n / (-2)
			} else {
				n = n/(-2) + 1
			}
			c := strconv.Itoa(lastN - ((-2) * n))
			s = c + s
		}
	}
	s = "1" + s
	return s
}
