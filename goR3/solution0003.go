package main
func LengthOfLongestSubstring(s string) int {
	//滑动数组
	//本方法左指针是一位一位加的，不好，更好的解决方案是map的value记录key出行的最后一个位置，左指针直接定位到value之后
	m := make(map[byte]int)

	if s == "" {
		return 0
	}
	i, j := 0, 1
	m[s[i]] = 1
	res := 1

	for j < len(s) {
		_, ok := m[s[j]]
		if !ok {
			m[s[j]] = 1
			if j-i+1 > res {
				res = j - i + 1
			}
		} else {
			m[s[j]] += 1
			for m[s[j]] > 1 {
				m[s[i]] -= 1
				i++
			}
			if j-i+1 > res {
				res = j - i + 1
			}
		}
		j++
	}

	return res
}
