package solution

func MaxScore(s string) int {
	count0, count1 := 0, 0
	for _, val := range s {
		if val == '1' {
			count1++
		}
	}
	if s[0] == '0' {
		count0 = 1
	} else {
		count1--
	}
	max := count0 + count1

	for i := 1; i < len(s)-1; i++ {
		if s[i] == '0' {
			count0++
		} else {
			count1--
		}
		if count0+count1 > max {
			max = count0 + count1
		}
	}
	return max
}
