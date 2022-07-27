package solution

import "sort"

func ArrayRankTransform(arr []int) []int {
	m := make(map[int]int)
	oldArr := append([]int{}, arr...)
	sort.Ints(arr)
	for _, value := range arr {
		_, ok := m[value]
		if !ok {
			m[value] = len(m) + 1
		}
	}
	res := make([]int, 0)
	for _, val := range oldArr {
		res = append(res, m[val])
	}
	return res
}
