package solution

import "sort"

func OrderlyQueue(s string, k int) string {
	if k == 1 {
		res := s
		for i := 0; i < len(s); i++ {
			s = s[1:] + string(s[0])
			if s < res {
				res = s
			}
		}
		return res
	} else {
		t := []rune(s)
		sort.Slice(t, func(i, j int) bool {
			return t[i] < t[j]
		})
		return string(t)
	}
}
