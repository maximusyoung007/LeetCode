package solution

//模拟
func CountTime(time string) int {
	t1 := time[0]
	t2 := time[1]
	t3 := time[3]
	t4 := time[4]
	res := 1
	if t1 == '?' {
		if t2 == '0' || t2 == '1' || t2 == '2' || t2 == '3' {
			res *= 3
		} else if t2 == '4' {
			if (t3 == '0' && t4 == '0') || (t3 == '?' && t4 == '?') {
				res *= 3
			} else {
				res *= 2
			}
		} else if t2 == '?' {
			res *= 24
		} else {
			res *= 2
		}
	} else {
		if t2 == '?' {
			if t1 == '0' || t1 == '1' {
				res *= 10
			} else {
				res *= 4
			}
		}
	}
	if t3 == '?' {
		res *= 6
	}
	if t4 == '?' {
		res *= 10
	}
	return res
}
