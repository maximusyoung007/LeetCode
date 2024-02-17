package solution

func PartitionLabels(s string) []int {
	m := make(map[string]int)
	length := len(s)

	for i := 0; i < length; i++ {
		m[string(s[i])] = i
	}

	end, lastNum := 0, 0
	res := make([]int, 0)
	for i := 0; i < length; i++ {
		//至少要到第end位
		if m[string(s[i])] > end {
			end = m[string(s[i])]
		}
		if i == end {
			res = append(res, i-lastNum+1)
			lastNum = i + 1
		}
	}
	return res
}
