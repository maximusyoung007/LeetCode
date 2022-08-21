package solution

import "strings"

func IsPrefixOfWord(sentence string, searchWord string) int {
	arr := strings.Split(sentence, " ")
	for index, val := range arr {
		if strings.HasPrefix(val, searchWord) {
			return index + 1
		}
	}
	return -1
}
