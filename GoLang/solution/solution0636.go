package solution

import (
	"strconv"
	"strings"
)

func ExclusiveTime(n int, logs []string) []int {
	res := make([]int, n)
	//stack存的是函数下标，t存的是上一个时间片位置
	var t int
	stack := make([]int, 0)
	for _, val := range logs {
		s := strings.Split(val, ":")
		if s[1] == "start" {
			value, _ := strconv.Atoi(s[2])
			index, _ := strconv.Atoi(s[0])
			if len(stack) != 0 {
				res[stack[len(stack)-1]] += value - t
			}
			stack = append(stack, index)
			t = value
		} else {
			value, _ := strconv.Atoi(s[2])
			res[stack[len(stack)-1]] += value - t + 1
			stack = stack[0 : len(stack)-1]
			t = value + 1
		}
	}
	return res
}
