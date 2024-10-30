package main

func RomanToInt(s string) int {
    res := 0
	n := len(s)
	for i := 0; i < n; i++ {
		switch s[i] {
			case 'I':
				if i+1 < n {
					if s[i+1] == 'V' {
						res += 4
						i++
					} else if s[i+1] == 'X' {
						res += 9
						i++
					} else {
						res += 1
					}
				} else {
					res += 1
				}
			case 'X':
				if i+1 < n {
					if s[i+1] == 'L' {
						res += 40
						i++
					} else if s[i+1] == 'C' {
						res += 90
						i++
					} else {
						res += 10
					}
				} else {
					res += 10
				}
			case 'C':
				if i+1 < n {
					if s[i+1] == 'D' {
						res += 400
						i++
					} else if s[i+1] == 'M' {
						res += 900
						i++
					} else {
						res += 100
					}
				} else {
					res += 100
				}
			case 'V':
				res += 5
			case 'L':
				res += 50
			case 'D':
				res += 500
			case 'M':
				res += 1000
			default:
				res = res
		}
	}

	return res
}