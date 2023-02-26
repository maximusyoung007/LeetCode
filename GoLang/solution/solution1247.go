package solution

import "strings"

func MinimumSwap(s1 string, s2 string) int {
	var build1 strings.Builder
	l := len(s1)
	for i := 0; i < l; i++ {
		if s1[i] != s2[i] {
			build1.WriteString(string(s1[i]))
		}
	}

	sb1 := build1.String()

	ll := len(sb1)
	if ll%2 != 0 {
		return -1
	}
	countX := 0
	for i := 0; i < ll; i++ {
		if sb1[i] == 'x' {
			countX++
		}
	}
	if countX%2 == 0 {
		return ll / 2
	} else {
		return ll/2 + 1
	}
}
