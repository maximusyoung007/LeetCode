package solution

func IsBipartite(graph [][]int) bool {
	//节点个数
	nums := len(graph)
	colors := make([]int, nums)
	//默认都没有染色
	queue := make([]int, 0)
	for i := 0; i < nums; i++ {
		if len(graph[i]) > 0 {
			colors[0] = 1
			queue = append(queue, 0)
			break
		}
	}

	for len(queue) > 0 {
		t := queue[0]
		queue = queue[1:]
		for i := 0; i < len(graph[t]); i++ {
			if colors[graph[t][i]] == colors[t] {
				return false
			}

			if colors[graph[t][i]] == 0 {
				colors[graph[t][i]] = colors[t] * -1
				queue = append(queue, graph[t][i])
			}
		}
	}

	return true
}
