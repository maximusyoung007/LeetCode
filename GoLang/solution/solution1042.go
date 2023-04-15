package solution

func GardenNoAdj(n int, paths [][]int) []int {
	//邻接表
	m := make([][]int, n+1)
	for _, v := range paths {
		m[v[0]] = append(m[v[0]], v[1])
		m[v[1]] = append(m[v[1]], v[0])
	}

	res := make([]int, n+1)
	for k, v := range m {
		colored := make([]int, 5)
		for i := 0; i < len(v); i++ {
			//v[i]表示相邻的某个花园
			//res[v[i]]表示这个花园种的是某种花
			//color表示相邻的地方，这种花已经种过了
			colored[res[v[i]]] = 1
		}
		for i := 1; i <= 4; i++ {
			if colored[i] == 0 {
				res[k] = i
				break
			}
		}
	}
	return res[1:]
}
