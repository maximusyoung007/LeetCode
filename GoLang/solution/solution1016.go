package solution

import (
	"strconv"
)

func QueryString(s string, n int) bool {
	m := make(map[int]int, 0)
	for i := 0; i < len(s); i++ {
		for j := i; j < len(s); j++ {
			ps := s[i : j+1]
			//0 以及 0开头的全都跳过
			if len(ps) == 1 && ps == "0" {
				break
			}
			num := two2Ten(ps, n)
			if num <= n {
				m[num] = 1
			}
		}
	}
	return len(m) == n
}

func two2Ten(s string, n int) int {
	res := 0
	twos := 2
	for i := len(s) - 1; i >= 0; i-- {
		num, _ := strconv.Atoi(string(s[i]))
		if i == len(s)-1 {
			res += num
		} else {
			res += num * twos
			twos *= 2
		}
		if res > n {
			break
		}
	}
	return res
}
