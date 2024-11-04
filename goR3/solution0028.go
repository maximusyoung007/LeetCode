package main

func StrStr(haystack string, needle string) int {
	//滑动窗口
	i, j, k := 0, 0, 0

	for i < len(haystack) && j < len(haystack) {
		if i == j {
			//滑动窗口开始，移动j
			if haystack[i] != needle[0] {
				i++
				j++
			} else {
				j++
				k++
			}
		}
		if i != j {
			for j < len(haystack) && j-i < len(needle) &&
				haystack[j] == needle[k] {
				j++
				k++
			}
			if k == len(needle) {
				return i
			} else {
				i++
				j = i
				k = 0
			}
		}
	}
	return -1
}
