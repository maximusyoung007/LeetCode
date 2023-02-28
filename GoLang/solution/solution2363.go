package solution

import "sort"

func MergeSimilarItems(items1 [][]int, items2 [][]int) [][]int {
	m := make(map[int]int)
	keys := make([]int, 0)
	for _, v := range items1 {
		m[v[0]] = v[1]
		keys = append(keys, v[0])
	}

	for _, v := range items2 {
		_, ok := m[v[0]]
		if ok {
			m[v[0]] = m[v[0]] + v[1]
		} else {
			m[v[0]] = v[1]
			keys = append(keys, v[0])
		}
	}
	res := make([][]int, 0)
	sort.Ints(keys)
	for _, k := range keys {
		t := []int{k, m[k]}
		res = append(res, t)
	}
	return res
}
