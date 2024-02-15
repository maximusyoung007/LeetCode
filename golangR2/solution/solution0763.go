package solution

func PartitionLabels(s string) []int {
	m := make(map[string]int)
	length := len(s)

	for i := 0; i < length; i++ {
		m[string(s[i])] = i
	}

	j := 0
	for i := 0; i < length && j < length; {
		if m[string(s[i])] != i {
			i++
		}
		if m[string(s[i])] == i {
			j = i + 1
			for j < length && m[string(s[j])] == j {
				j++
			}
			j--
			res = append(res, j-lastNum+1)
			lastNum = j + 1
			i = j
		}
	}
	return res
}
