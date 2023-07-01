package solution

import "fmt"

func pacificAtlantic(heights [][]int) [][]int {
	visited := make([][]bool, len(heights))
	for i := 0; i < len(heights); i++ {
		visited[i] = make([]bool, len(heights[0]))
	}
	res := make([][]int, 0)
	var p, a bool
	nextMove := [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}
	for i := 0; i < len(heights); i++ {
		for j := 0; j < len(heights[0]); j++ {
			p = false
			a = false
			dfs0417(heights, res, i, j, &p, &a, nextMove, visited)
			if a && p {
				res = append(res, []int{i, j})
			}
			for i := 0; i < len(visited); i++ {
				for j := 0; j < len(visited[0]); j++ {
					visited[i][j] = false
				}
			}
		}
	}
	return res
}

func dfs0417(heights [][]int, res [][]int, currentI int, currentJ int, p *bool, a *bool, nextMove [][]int, visited [][]bool) {
	visited[currentI][currentJ] = true
	//流进了太平洋
	if currentI == 0 || currentJ == 0 {
		*p = true
	}

	//流进了大西洋
	if currentI == len(heights)-1 || currentJ == len(heights[0])-1 {
		*a = true
	}

	for i := 0; i < len(nextMove); i++ {
		nextI := currentI + nextMove[i][0]
		nextJ := currentJ + nextMove[i][1]
		if nextI >= 0 && nextI <= len(heights)-1 && nextJ >= 0 && nextJ <= len(heights[0])-1 {
			if !visited[nextI][nextJ] && heights[nextI][nextJ] <= heights[currentI][currentJ] {
				dfs0417(heights, res, nextI, nextJ, p, a, nextMove, visited)
			}
		}
	}
}

func Test0417() {
	heights := [][]int{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}
	//heights := [][]int{{2, 1}, {1, 2}}
	fmt.Println(pacificAtlantic(heights))
}
