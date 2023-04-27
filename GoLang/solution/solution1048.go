package solution

import "sort"

// LongestStrChain
// 先对words按长度排序
//map用来存储每个字符串的最长字符串链长度
// s的前置字符串为t,m[s]=m[t]+1
func LongestStrChain(words []string) int {
	sort.Slice(words, func(i, j int) bool {
		return len(words[i]) < len(words[j])
	})
	m := make(map[string]int, 0)
	res := 0
	for _, word := range words {
		if len(word) == 1 {
			m[word] = 1
		}
		maxT := 0
		for i := 0; i < len(word); i++ {
			t := word[:i] + word[i+1:]
			if m[t] > maxT {
				maxT = m[t]
			}
		}
		m[word] = maxT + 1
		if m[word] > res {
			res = m[word]
		}
	}
	return res
}
