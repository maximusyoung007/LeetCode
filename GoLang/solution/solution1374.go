package solution

func GenerateTheString(n int) string {
	if n == 1 {
		return "a"
	}
	if n == 2 {
		return "ab"
	}
	s := ""
	for i := 0; i < n-2; i++ {
		s += "a"
	}
	if n%2 == 0 {
		s += "a"
		s += "b"
	} else {
		s += "b"
		s += "c"
	}
	return s
}
