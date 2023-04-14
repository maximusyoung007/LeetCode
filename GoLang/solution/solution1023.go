package solution

//双指针
func CamelMatch(queries []string, pattern string) []bool {
	res := make([]bool, 0)
	has := false
	for _, q := range queries {
		index := 0
		has = false
		for i := 0; i < len(q); i++ {
			if index < len(pattern) && q[i] == pattern[index] {
				index++
			} else {
				if q[i] >= 'A' && q[i] <= 'Z' {
					res = append(res, false)
					has = true
					break
				}
			}
		}
		if !has {
			if index != len(pattern) {
				res = append(res, false)
			} else {
				res = append(res, true)
			}
		}
	}
	return res
}
