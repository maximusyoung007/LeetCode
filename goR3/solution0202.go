package main

func IsHappy(n int) bool {
	t := 0
	m := make(map[int]int)
	for n > 0 {
		last := n % 10
		t += last * last
		n /= 10
		if n == 0 {
			if t == 1 {
				return true
			}
			_, ok := m[t]
			if ok {
				return false
			} else {
				m[t] = 1
			}

			n = t
			t = 0
		}
	}

	return true
}
