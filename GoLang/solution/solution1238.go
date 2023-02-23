package solution

/*
*
找规律
0 1 3 2 扩展成 0 1 3 2 6 7 5 4
0 + 2^2 = 4
1 + 2^2 = 5
3 + 2^2 = 7
2 + 2^2 = 6
后面以0 1 3 2 6 7 5 4为基础扩展，+2^3,
......
依次类推
后面再调整一下顺序即可
*/
func CircularPermutation(n int, start int) []int {
	var res []int
	startIndex := 0
	if n == 1 {
		if start == 1 {
			return []int{1, 0}
		} else {
			return []int{0, 1}
		}
	} else {
		res = []int{0, 1, 3, 2}
		if n != 2 {
			for n > 2 {
				l := len(res)
				for i := l - 1; i >= 0; i-- {
					newElement := res[i] + CalTwo(n-1)
					res = append(res, newElement)
					if res[i] == start {
						startIndex = i
					}
					if newElement == start {
						startIndex = len(res) - 1
					}
				}
				n--
			}
		} else {
			for i := 0; i < len(res); i++ {
				if res[i] == start {
					startIndex = i
				}
			}
		}

	}
	part1 := res[0:startIndex]
	part2 := res[startIndex:]
	for _, v := range part1 {
		part2 = append(part2, v)
	}
	return part2
}

func CalTwo(n int) int {
	return 1 << n
}
