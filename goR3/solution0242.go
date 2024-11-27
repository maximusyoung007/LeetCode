package main

func IsAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
    m1 := make(map[byte]int)
    m2 := make(map[byte]int)

	for i := 0; i < len(s); i++ {
		_, ok := m1[s[i]]
		if ok {
			m1[s[i]]++
		} else {
			m1[s[i]] = 1
		}

		_, ok2 := m2[t[i]]
		if ok2 {
			m2[t[i]]++
		} else {
			m2[t[i]] = 1
		}
	}

	for key, value := range m1 {
		_, ok := m2[key]
		if !ok {
			return false
		}

		if m2[key] != value {
			return false
		}
	}

	return true
}	