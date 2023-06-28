package solution

import "fmt"

func maxAreaOfIsland(grid [][]int) int {
	res := 0
	maxRes := 0

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == 1 {
				dfs695(grid, i, j, &res)
				if res > maxRes {
					maxRes = res
				}
				res = 0
			}
		}
	}

	return maxRes
}

func dfs695(grid [][]int, i int, j int, res *int) {
	//越界
	if i < 0 || i >= len(grid) || j < 0 || j >= len(grid[0]) {
		return
	}

	if grid[i][j] == 0 {
		return
	}

	if grid[i][j] == 1 {
		//表示访问过了
		grid[i][j] = 0
		*res++
	}

	dfs695(grid, i+1, j, res)
	dfs695(grid, i, j+1, res)
	dfs695(grid, i-1, j, res)
	dfs695(grid, i, j-1, res)
}

func Test0695() {
	grid := [][]int{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
		{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}

	fmt.Println(maxAreaOfIsland(grid))

}
