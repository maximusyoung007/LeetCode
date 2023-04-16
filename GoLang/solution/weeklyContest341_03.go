package solution

import "strings"

func AddMinimum(word string) int {
	var t string
	res := 0
	for i := 0; i < len(word); i++ {
		if strings.Contains(t, string(word[i])) {
			//如果当前字符重复了，则表示开始一个新的abc
			res += 3 - len(t)
			t = ""
			t = t + string(word[i])
		} else if i > 0 && word[i] < word[i-1] {
			//如果逆序了，则表示开始一个新的abc
			res += 3 - len(t)
			t = ""
			t = t + string(word[i])
		} else {
			t = t + string(word[i])
		}
	}
	res += 3 - len(t)
	return res
}
