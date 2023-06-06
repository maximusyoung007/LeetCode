package solution

import "strconv"

func EqualPairs(grid [][]int) int {
	res := 0
	m := make(map[string]int)
	for _, g := range grid {
		s := ""
		for _, v := range g {
			c := strconv.Itoa(v)
			s = s + c + ","
		}
		m[s]++
	}

	for j := 0; j < len(grid[0]); j++ {
		s := ""
		for i := 0; i < len(grid); i++ {
			c := strconv.Itoa(grid[i][j])
			s = s + c + ","
		}
		_, ok := m[s]
		if ok {
			res += m[s]
		}
	}
	return res
}
