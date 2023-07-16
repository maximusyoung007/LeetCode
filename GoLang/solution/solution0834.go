package solution

import "fmt"

func sumOfDistancesInTree(n int, edges [][]int) []int {
	table := make(map[int][]int)
	for _, edge := range edges {
		if len(edge) == 0 {
			return []int{0}
		}
		table[edge[0]] = append(table[edge[0]], edge[1])
		table[edge[1]] = append(table[edge[1]], edge[0])
	}

	var dfs func(father int, now int, d int)
	dis := 0
	sons := make([]int, n)
	dfs = func(father int, now int, d int) {
		t := table[now]
		d++
		sons[now] = 1
		for i := 0; i < len(t); i++ {
			if t[i] != father {
				dis += d
				dfs(now, t[i], d)
				sons[now] += sons[t[i]]
			}
		}
	}

	dfs(-1, 0, 0)

	res := make([]int, n)
	res[0] = dis
	var reRoot func(fatherDis int, father int, now int)
	reRoot = func(fatherDis int, father int, now int) {
		t := table[now]
		if now != 0 {
			res[now] = fatherDis - sons[now] + n - sons[now]
		}
		for i := 0; i < len(t); i++ {
			if father != t[i] {
				reRoot(res[now], now, t[i])
			}
		}
	}

	reRoot(dis, -1, 0)

	return res
}

func Test0834() {
	//n, edges := 6, [][]int{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}}
	//n, edges := 4, [][]int{{1, 2}, {3, 2}, {3, 0}}
	//n, edges := 1, [][]int{{}}
	n, edges := 2, [][]int{{1, 0}}
	fmt.Println(sumOfDistancesInTree(n, edges))
}
