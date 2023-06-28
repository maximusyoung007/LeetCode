package solution

import "fmt"

func numEnclaves(grid [][]int) int {
	res := 0
	reachBorder := false
	totalRes := 0

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == 1 {
				dfs1020(grid, i, j, &res, &reachBorder)
				if !reachBorder {
					totalRes += res
				}
				res = 0
				reachBorder = false
			}
		}
	}

	return totalRes
}

func dfs1020(grid [][]int, i int, j int, res *int, reachBorder *bool) {
	if grid[i][j] == 0 {
		return
	}

	if grid[i][j] == 1 {
		//到达了边界，所有连通的1都作废
		if i == 0 || i == len(grid)-1 || j == 0 || j == len(grid[0])-1 {
			*reachBorder = true
			return
		} else {
			//表示访问过了
			grid[i][j] = 0
			*res++
		}
	}

	dfs1020(grid, i+1, j, res, reachBorder)
	dfs1020(grid, i, j+1, res, reachBorder)
	dfs1020(grid, i-1, j, res, reachBorder)
	dfs1020(grid, i, j-1, res, reachBorder)
}

func Test1020() {
	//grid := [][]int{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}
	grid := [][]int{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}
	fmt.Println(numEnclaves(grid))

}
