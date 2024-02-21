package solution

import "strings"

func FindLongestWord(s string, dictionary []string) string {
	res := ""
	for _, d := range dictionary {
		if isSubStr(s, d) {
			if res == "" {
				res = d
			} else if len(d) > len(res) {
				//长度最长
				res = d
			} else if len(d) == len(res) && strings.Compare(d, res) < 0 {
				//字典序最小
				res = d
			}
		}
	}
	return res
}

// s是否包含t的所有字符
func isSubStr(s string, d string) bool {
	i, j := 0, 0
	dLength := len(d)
	for i < len(s) && j < dLength {
		if s[i] == d[j] {
			j++
		}
		i++
	}
	if j == dLength {
		return true
	}
	return false
}
