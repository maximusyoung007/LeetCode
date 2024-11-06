package main

import "strings"

func IsPalindrome(s string) bool {
	
	i, j := 0, len(s)-1

	for i <= j {
		if !((s[i] <= 'Z' && s[i] >= 'A') || (s[i] <= 'z' && s[i] >= 'a') || (s[i] <= '9' && s[i] >= '0')) {
			i++
			continue
		}
		if !((s[j] <= 'Z' && s[j] >= 'A') || (s[j] <= 'z' && s[j] >= 'a') || (s[j] <= '9' && s[j] >= '0')) {
			j--
			continue
		}
		if strings.EqualFold(strings.ToLower(string(s[i])), strings.ToLower(string(s[j]))) {
			i++
			j--
		} else {
			return false
		}
	}

	return true
}