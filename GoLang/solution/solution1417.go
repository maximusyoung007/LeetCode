package solution

func Reformat(s string) string {
	s1 := make([]string, 0)
	s2 := make([]string, 0)
	for _, val := range s {
		if val >= '0' && val <= '9' {
			s1 = append(s1, string(val))
		} else {
			s2 = append(s2, string(val))
		}
	}
	if len(s1)-len(s2) >= 2 || len(s1)-len(s2) <= -2 {
		return ""
	}
	var res string

	if len(s1) != len(s2) {
		if len(s1) > len(s2) {
			for i := 0; i < len(s1) && i < len(s2); i++ {
				res += s1[i]
				res += s2[i]
			}
			res += s1[len(s1)-1]
		} else {
			for i := 0; i < len(s1) && i < len(s2); i++ {
				res += s2[i]
				res += s1[i]
			}
			res += s2[len(s2)-1]
		}
	} else {
		for i := 0; i < len(s1) && i < len(s2); i++ {
			res += s1[i]
			res += s2[i]
		}
	}
	return res
}
