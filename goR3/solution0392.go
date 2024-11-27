package main

func IsSubsequence(s string, t string) bool {
	i, j := 0, 0

	for i < len(s) && j < len(t) {
		if s[i] != t[j] {
			j++
		} else {
			i++
			j++
		}
	}

	return i == len(s)
}
