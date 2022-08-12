package solution

func GroupThePeople(groupSizes []int) [][]int {
	res := make([][]int, 0)
	temp := make([][]int, len(groupSizes) + 1)
	for i := 0; i < len(groupSizes); i++ {
		if temp[groupSizes[i]] == nil || len(temp[groupSizes[i]]) == 0 {
			temp[groupSizes[i]] = make([]int, 0)
		}
		temp[groupSizes[i]] = append(temp[groupSizes[i]], i)
		if len(temp[groupSizes[i]]) == groupSizes[i] {
			res = append(res, temp[groupSizes[i]])
			temp[groupSizes[i]] = make([]int, 0)
		}
	}
	return res
}
