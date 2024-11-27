package main

import "math"

func MinWindow(s string, t string) string {
	m1 := make(map[byte]int)

	for i := range t {
		b := t[i]

		_, ok := m1[b]
		if ok {
			m1[b]++
		} else {
			m1[b] = 1
		}
	}

	i, j := 0, 0
	min := math.MaxInt
	res := ""

	m2 := make(map[byte]int)
	for i <= j && j < len(s) {
		_, ok := m1[s[j]]
		if !ok {
			if i == j {
				i++
				j++
			} else {
				j++
			}
		} else {
			_, ok2 := m2[s[j]]
			if !ok2 {
				m2[s[j]] = 1
			} else {
				m2[s[j]]++
			}
			if len(m2) == len(m1) {
				//把所有不符合要求的先删掉，可以计算最小长度
				_, ok4 := m1[s[i]]
				for i < len(s) {
					if !ok4 {
						i++
						_, ok4 = m1[s[i]]
					}
					if ok4 {
						if m2[s[i]] > m1[s[i]] {
							if m2[s[i]] > 1 {
								m2[s[i]]--
							} else {
								delete(m2, s[i])
							}
							i++
							_, ok4 = m1[s[i]]
						} else {
							break
						}

					}
				}

				isMatch := true
				for key, value := range m2 {
					if value < m1[key] {
						isMatch = false
					}
				}

				if isMatch {
					if j-i+1 < min {
						min = j - i + 1
						res = s[i : j+1]
					}

					//i的位置肯定是合法的，删掉
					m2[s[i]]--
					if m2[s[i]] == 0 {
						delete(m2, s[i])
					}

					i++

				}
			}
			j++
		}
	}

	return res
}
