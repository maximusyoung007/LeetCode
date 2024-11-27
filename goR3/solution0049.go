package main

import "sort"

func GroupAnagrams(strs []string) [][]string {
	m := make(map[string][]string)

	sortStrings := func(s string) string {
		runes := []rune(s)
		sort.Slice(runes, func(i, j int) bool {
			return runes[i] < runes[j]
		})
		return string(runes)
	}

	for i := 0; i < len(strs); i++ {
		sortS := sortStrings(strs[i])

		_, ok := m[sortS]
		var ss []string
		if ok {
			ss = m[sortS]
		} else {
			ss = make([]string, 0)
		}

		ss = append(ss, strs[i])
		m[sortS] = ss
	}

	res := make([][]string, 0)
	for _, value := range m {
		res = append(res, value)
	}

	return res
}
