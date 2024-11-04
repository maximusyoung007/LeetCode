package main

func Convert(s string, numRows int) string {
	//遍历看每一个字母在哪一行
	line := 0
	isUp := true
	m := make(map[int][]byte)
	for i := 0; i < len(s); i++ {
		_, ok := m[line]
		var b []byte
		if ok {
			b = m[line]
		} else {
			b = make([]byte, 0)
		}

		b = append(b, s[i])
		m[line] = b

		if isUp {
			line++
			if line == numRows {
				line--
			}
		} else {
			line--
		}

		if line == numRows-1 {
			isUp = false
		} else if line == 0 {
			isUp = true
		}

	}

	res := ""
	for i := 0; i < numRows; i++ {
		value := m[i]
		for _, val := range value {
			res = res + string(val)
		}
	}
	return res
}
