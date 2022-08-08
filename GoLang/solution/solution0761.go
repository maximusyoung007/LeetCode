package solution

import "sort"

func MakeLargestSpecial(s string) string {
	if len(s) <= 2 {
		return s
	}
	count, left := 0, 0
	subs := make([]string, 0)
	for i := 0; i < len(s); i++ {
		if s[i] == '1' {
			count++
		} else {
			count--
		}
		if count == 0 {
			ts := "1" + MakeLargestSpecial(s[left+1:i]) + "0"
			subs = append(subs, ts)
			left = i + 1
		}
	}

	sort.Slice(subs, func(i, j int) bool {
		return subs[i] > subs[j]
	})

	var res string
	for _, val := range subs {
		res = res + val
	}
	return res
}
