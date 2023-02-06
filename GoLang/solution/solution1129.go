package solution

func ShortestAlternatingPaths(n int, redEdges [][]int, blueEdges [][]int) []int {
	var queue [][2]int
	//邻接表
	redTable := make(map[int][]int)
	blueTable := make(map[int][]int)
	//当前节点是否访问过
	visited := make([][]bool, n)
	for i := 0; i < n; i++ {
		visited[i] = make([]bool, 2)
	}
	for i := 0; i < n; i++ {
		for j := 0; j < 2; j++ {
			visited[i][j] = false
		}
	}
	res := make([]int, n)
	for i := 0; i < n; i++ {
		res[i] = -1
	}

	if len(redEdges) > 0 {
		for _, val := range redEdges {
			_, ok := redTable[val[0]]
			if ok {
				redTable[val[0]] = append(redTable[val[0]], val[1])
			} else {
				redTable[val[0]] = []int{val[1]}
			}
		}
	}
	if len(blueEdges) > 0 {
		for _, val := range blueEdges {
			_, ok := blueTable[val[0]]
			if ok {
				blueTable[val[0]] = append(blueTable[val[0]], val[1])
			} else {
				blueTable[val[0]] = []int{val[1]}
			}
		}
	}

	queue = append(queue, [2]int{0, 0})
	queue = append(queue, [2]int{0, 1})

	//层序遍历，每一层层数即为最短距离
	d := 0

	for len(queue) > 0 {
		for k := len(queue); k > 0; k-- {
			node := queue[0]
			nodeVal := node[0]
			nodeColor := node[1]
			if res[nodeVal] == -1 {
				res[nodeVal] = d
			}
			visited[nodeVal][nodeColor] = true
			_, okRed := redTable[nodeVal]
			if okRed {
				for _, val := range redTable[nodeVal] {
					//现在是nodeColor==1蓝色，则下一个应该是红色
					//此处visited判断的是下一个
					if !visited[val][1-nodeColor] && nodeColor == 1 {
						queue = append(queue, [2]int{val, 0})
					}
				}
			}

			_, okBlue := blueTable[nodeVal]
			if okBlue {
				for _, val := range blueTable[nodeVal] {
					//现在是nodeColor==0红色，则下一个应该是蓝色
					if !visited[val][1-nodeColor] && nodeColor == 0 {
						queue = append(queue, [2]int{val, 1})
					}
				}
			}
			queue = queue[1:]
		}
		d++
	}
	return res
}
