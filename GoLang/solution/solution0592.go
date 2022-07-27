package solution

import (
	"math"
	"strconv"
)

func FractionAddition(expression string) string {
	var es [][]string
	lcm := 0
	for i := 0; i < len(expression); i++ {
		if expression[i] == '/' {
			if len(es) == 0 {
				lcm = 1
			}
			s, j := "", 0
			for j = i - 1; j >= 0; j-- {
				if expression[j] > '9' || expression[j] < '0' {
					if expression[j] == '-' {
						s = "-"
					} else {
						s = "+"
					}
					break
				}
			}
			if j == -1 {
				s = "+"
			}
			pre := expression[j+1 : i]
			for j = i + 1; j < len(expression); j++ {
				if expression[j] > '9' || expression[j] < '0' {
					break
				}
			}
			next := expression[i+1 : j]
			strs := []string{s, pre, next}
			nextNum, _ := strconv.Atoi(next)
			lcm = l(lcm, nextNum)
			es = append(es, strs)
		}
	}
	num := 0
	for _, str := range es {
		num2, _ := strconv.Atoi(str[1])
		num3, _ := strconv.Atoi(str[2])
		i := num2 * (lcm / num3)
		if str[0] == "+" {
			num += i
		} else {
			num -= i
		}
	}

	z := measure(num, lcm)
	num /= z
	lcm /= z
	if num == 0 {
		return strconv.Itoa(num) + "/1"
	} else {
		if num*lcm > 0 {
			return strconv.Itoa(num) + "/" + strconv.Itoa(lcm)
		} else {
			return "-" + strconv.Itoa(int(math.Abs((float64(num))))) + "/" + strconv.Itoa(int(math.Abs((float64(lcm)))))
		}
	}
}

func l(m int, n int) int {
	if m > n {
		m, n = n, m
	}
	for i := m; i < m*n; i++ {
		if i%m == 0 && i%n == 0 {
			return i
		}
	}
	return m * n
}

func measure(x int, y int) int {
	z := y
	for x%y != 0 {
		z = x % y
		x = y
		y = z
	}
	return z
}
