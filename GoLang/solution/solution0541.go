package solution

import (
	"strings"
)

func ReverseStr(s string, k int) string {
	var build strings.Builder

	for len(s) > 2 * k {
		s1 := Reverse(s[0:k])
		s2 := s[k:2*k]
		s3 := s[2*k:]

		build.WriteString(s1)
		build.WriteString(s2)

		s = s3
	}

	if len(s) < k {
		build.WriteString(Reverse(s[0:len(s)]))
	} else if len(s) >= k {
		build.WriteString(Reverse(s[0:k]))
		build.WriteString(s[k:len(s)])
	}

	return build.String()

}

func Reverse(str string) string {
	r := []rune(str)
	for left, right := 0, len(r) - 1; left < right; left, right = left + 1, right - 1 {
		r[left], r[right] = r[right], r[left]
	}
	res := string(r)
	return res
}
