package main

func SpiralOrder(matrix [][]int) []int {
	//d表示方向，0，1，2，3分别表示右，下，左，上
	//到达边界或者已访问节点时改变方向
	d := 0
	
	k := 0
	i, j, k := 0, 0, 0
	
	m, n := len(matrix), len(matrix[0])
	total := m * n
	res := make([]int, total)
	visited := make([][]int, m)
	for v := 0; v < m; v++ {
		visited[v] = make([]int, n)
	}
	for k < total {
		res[k] = matrix[i][j]
		visited[i][j] = 1
		k++

		if d == 0 {
			j++

			if j == n || visited[i][j] == 1 {
				j--
				d++
			}
		}

		//改变方向后会继续往1的方向走，1->2,2->3同理
		if d == 1 {
			i++

			if i == m || visited[i][j] == 1 {
				i--
				d++
			}
		}

		if d == 2 {
			j--

			if j == -1 || visited[i][j] == 1 {
				j++
				d++
			}
		}

		if d == 3 {
			i--

			if i == -1 || visited[i][j] == 1 {
				i++
				d = 0
				//最后一次改变方向后不会在自动往新方向走，需要走一位
				j++
			}
		}
	}

	return res
}