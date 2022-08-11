package solution

import (
	"strconv"
	"strings"
)

func SolveEquation(equation string) string {
	arr := strings.Split(equation, "=")
	s1 := arr[0]
	s2 := arr[1]

	//统计左右两边正的x的数量以及左右两边的和
	leftX, rightX := 0, 0
	leftSum, rightSum := 0, 0

	num := 0
	op := 1
	for i := 0; i < len(s1); {
		if s1[i] == '+' {
			op = 1
			i++
		} else if s1[i] == '-' {
			op = -1
			i++
		} else {
			var s string
			if s1[i] == 'x' {
				if op == 1 {
					leftX++
				} else {
					rightX++
				}
				i++
			} else {
				for i < len(s1) && s1[i] >= '0' && s1[i] <= '9' {
					s = s + string(s1[i])
					i++
				}
				num, _ = strconv.Atoi(s)
				if i < len(s1) {
					if s1[i] == 'x' {
						if op == 1 {
							leftX += num
						} else {
							rightX += num
						}
						i++
					} else {
						if op == 1 {
							leftSum += num
						} else {
							leftSum -= num
						}
					}
				} else {
					if op == 1 {
						leftSum += num
					} else {
						leftSum -= num
					}
				}
			}
		}
	}

	op = 1
	for i := 0; i < len(s2); {
		if s2[i] == '+' {
			op = 1
			i++
		} else if s2[i] == '-' {
			op = -1
			i++
		} else {
			var s string
			if s2[i] == 'x' {
				if op == 1 {
					rightX++
				} else {
					leftX++
				}
				i++
			} else {
				for i < len(s2) && s2[i] >= '0' && s2[i] <= '9' {
					s = s + string(s2[i])
					i++
				}
				num, _ = strconv.Atoi(s)
				if i < len(s2) {
					if s2[i] == 'x' {
						if op == 1 {
							rightX += num
						} else {
							leftX += num
						}
						i++
					} else {
						if op == 1 {
							rightSum += num
						} else {
							rightSum -= num
						}
					}
				} else {
					if op == 1 {
						rightSum += num
					} else {
						rightSum -= num
					}
				}
			}
		}
	}

	sub := rightSum - leftSum
	if leftX == rightX {
		if sub == 0 {
			return "Infinite solutions"
		} else {
			return "No solution"
		}
	} else {
		subX := leftX - rightX
		return "x=" + strconv.Itoa(sub/subX)
	}
}
