package solution

func ColorTheArray(n int, queries [][]int) []int {
	res := make([]int, len(queries))
	colors := make([]int, n)

	current := 0
	for i := 0; i < len(queries); i++ {
		index := queries[i][0]
		color := queries[i][1]
		//如果是第一次上色，就不减掉
		if index-1 >= 0 && colors[index-1] == colors[index] && colors[index] != 0 {
			current--
		}
		if index+1 < n && colors[index+1] == colors[index] && colors[index] != 0 {
			current--
		}
		colors[index] = color
		if index-1 >= 0 && colors[index-1] == colors[index] && colors[index] != 0 {
			current++
		}
		if index+1 < n && colors[index+1] == colors[index] && colors[index] != 0 {
			current++
		}
		res[i] = current
	}
	return res
}
