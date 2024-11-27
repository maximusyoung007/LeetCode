package main

import "strings"

func WordPattern(pattern string, s string) bool {
	m1 := make(map[byte]string)
	m2 := make(map[string]byte)

	s1 := strings.Split(s, " ")

	if len(pattern) != len(s1) {
		return false
	}

	for i := 0; i < len(s1); i++ {
		_, ok := m1[pattern[i]]
		if ok {
			if m1[pattern[i]] != s1[i] {
				return false
			}
		} else {
			m1[pattern[i]] = s1[i]
		}

		_, ok2 := m2[s1[i]]
		if ok2 {
			if m2[s1[i]] != pattern[i] {
				return false
			}
		} else {
			m2[s1[i]] = pattern[i]
		}
	}

	return true
}