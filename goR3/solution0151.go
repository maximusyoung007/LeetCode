package main

import "strings"

func ReverseWords(s string) string {
    strs := strings.Split(s, " ")
	res := ""
	for i := len(strs) - 1; i >= 0; i-- {
		if strs[i] != "" {
			res = res + " " + strs[i]
		}
	}
	res = res[1:]

	return res
}