package main

func CanConstruct(ransomNote string, magazine string) bool {
    m := make(map[byte]int)

	for i := 0; i < len(magazine); i++ {
		b := magazine[i]
		_, ok := m[b]
		if !ok {
			m[b] = 1
		} else {
			m[b]++
		}
	}

	for i := 0; i < len(ransomNote); i++ {
		r := ransomNote[i]
		_, ok := m[r]
		if !ok {
			return false
		} else if m[r] <= 0 {
			return false
		} else {
			m[r]--
		}
	}

	return true

}