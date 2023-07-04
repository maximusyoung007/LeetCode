package solution

import "fmt"

func updateMatrix(mat [][]int) [][]int {
	res := make([][]int, len(mat))
	visited := make([][]int, len(mat))
	queue := make([][]int, 0)
	nextMove := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	for i := 0; i < len(mat); i++ {
		res[i] = make([]int, len(mat[0]))
		visited[i] = make([]int, len(mat[0]))
		for j := 0; j < len(mat[0]); j++ {
			if mat[i][j] == 0 {
				queue = append(queue, []int{i, j})
			}
		}
	}

	for len(queue) > 0 {
		t := queue[0]
		for i := 0; i < len(nextMove); i++ {
			nextI := t[0] + nextMove[i][0]
			nextJ := t[1] + nextMove[i][1]
			if nextI >= 0 && nextI < len(mat) && nextJ >= 0 && nextJ < len(mat[0]) && mat[nextI][nextJ] == 1 && visited[nextI][nextJ] == 0 {
				visited[nextI][nextJ] = 1
				res[nextI][nextJ] = res[t[0]][t[1]] + 1
				queue = append(queue, []int{nextI, nextJ})
			}
		}
		queue = queue[1:]
	}

	return res
}

func Test0542() {
	//[[0,0,0],[0,1,0],[0,0,0]]
	// [[0,0,0],[0,1,0],[1,1,1]]
	mat := [][]int{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}
	//mat := [][]int{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}
	res := updateMatrix(mat)
	fmt.Println(res)
}
