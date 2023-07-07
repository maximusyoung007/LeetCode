package solution

import "fmt"

func orangesRotting(grid [][]int) int {
	rotted := make([][]int, 0)
	rottedNum := 0
	allNum := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == 2 {
				rotted = append(rotted, []int{i, j})
				rottedNum++
				allNum++
			}
			if grid[i][j] == 1 {
				allNum++
			}
		}
	}

	nextMove := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	t := 0

	for len(rotted) > 0 {
		n := len(rotted)
		isRotted := false
		//第i分钟腐烂
		for l := 0; l < n; l++ {
			tr := rotted[0]
			rotted = rotted[1:]
			for i := 0; i < len(nextMove); i++ {
				nextI := tr[0] + nextMove[i][0]
				nextJ := tr[1] + nextMove[i][1]
				if nextI >= 0 && nextI < len(grid) && nextJ >= 0 && nextJ < len(grid[0]) {
					if grid[nextI][nextJ] == 1 {
						isRotted = true
						rotted = append(rotted, []int{nextI, nextJ})
						//将这个改成腐烂
						grid[nextI][nextJ] = 2
						rottedNum++
					}
				}
			}
		}
		//如果有腐烂的，时间+1
		if isRotted {
			t++
		}
	}
	if rottedNum == allNum {
		return t
	}
	return -1
}

func Test0994() {
	grid := [][]int{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}
	//grid := [][]int{{0, 2}}
	//grid := [][]int{{0}}
	//grid := [][]int{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}
	fmt.Println(orangesRotting(grid))
}
