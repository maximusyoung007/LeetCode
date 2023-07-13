package solution

import "fmt"

//填海造陆，最后填的就是最远的
func maxDistance(grid [][]int) int {
	type pair1162 struct {
		x, y int
	}
	var land []pair1162
	all := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == 1 {
				land = append(land, pair1162{i, j})
			}
			all++
		}
	}
	if len(land) == 0 || len(land) == all {
		return -1
	}

	nextMove := []pair1162{{1, 0}, {-1, 0}, {0, -1}, {0, 1}}
	dis := 0
	for len(land) > 0 {
		n := len(land)
		//每进行一次循环，就到了下一个距离的海域
		dis++
		for i := 0; i < n; i++ {
			t := land[0]
			land = land[1:]
			for _, move := range nextMove {
				nextI := t.x + move.x
				nextJ := t.y + move.y
				if nextI >= 0 && nextI < len(grid) && nextJ >= 0 && nextJ < len(grid[0]) {
					if grid[nextI][nextJ] == 0 {
						land = append(land, pair1162{nextI, nextJ})
						grid[nextI][nextJ] = 1
					}
				}
			}
		}
	}
	return dis - 1
}

func Test1162() {
	//grid := [][]int{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}
	grid := [][]int{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}
	fmt.Println(maxDistance(grid))
}
