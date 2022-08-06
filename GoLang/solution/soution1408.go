package solution

import "strings"

func StringMatching(words []string) []string {
	var res []string
	m := make(map[string]int, 0)
	for i := 0; i < len(words); i++ {
		for j := 0; j < len(words); j++ {
			if i != j {
				if strings.Index(words[j], words[i]) != -1 {
					_, ok := m[words[i]]
					if !ok {
						m[words[i]] = 0
					}
				}
			}
		}
	}
	for key, _ := range m {
		res = append(res, key)
	}
	return res
}
