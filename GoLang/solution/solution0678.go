package solution

func CheckValidString(s string) bool {
	leftCount, starCount := 0, 0
	var ss []byte = []byte(s)
	for _, val := range ss {
		if val == '(' {
			leftCount++
		} else if val == '*' {
			if leftCount > 0 {
				leftCount--
				starCount++
			}
			starCount++
		} else {
			if leftCount > 0 {
				leftCount--
			} else if starCount > 0 {
				starCount--
			} else {
				return false
			}
		}
	}
	return leftCount == 0
}
