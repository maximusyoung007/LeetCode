package main

func IsIsomorphic(s string, t string) bool {
    n := len(s)

	m1 := make(map[byte]byte)
	m2 := make(map[byte]byte)


	for i := 0; i < n; i++ {
		sb, tb := s[i], t[i]

		_, ok := m1[sb] 
		
		if !ok {
			m1[sb] = tb
		} else {
			if m1[sb] != tb {
				return false
			}
		}

		_, ok2 := m2[tb] 
		
		if !ok2 {
			m2[tb] = sb
		} else {
			if m2[tb] != sb {
				return false
			}
		}
	}

	return true
}