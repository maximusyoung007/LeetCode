package solution

import "sort"

func sortPeople(names []string, heights []int) []string {
	res := make([]string, 0)
	m := make(map[int]string, 0)
	for i := 0; i < len(heights); i++ {
		m[heights[i]] = names[i]
	}
	sort.Ints(heights)
	for i := len(heights) - 1; i >= 0; i-- {
		res = append(res, m[heights[i]])
	}
	return res
}
