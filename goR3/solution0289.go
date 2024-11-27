package main

import "fmt"

func GameOfLife(board [][]int) {
	/**
	1活0死
	如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
	如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
	如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
	如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
	*/
	m, n := len(board), len(board[0])

	direction := [][]int{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			live, die := 0, 0
			for k := 0; k < 8; k++ {
				newI := i + direction[k][0]
				newJ := j + direction[k][1]
				if newI >= 0 && newI < m && newJ >= 0 && newJ < n {
					//11 01 10 00第二位表示实际存储的1还是0 ，第一位表示是否需要修改
					if board[newI][newJ] % 10 == 1 {
						live++
					} else if board[newI][newJ] % 10 == 0 {
						die++
					}
				}
			}
			
			//11 1需要修改 01 1不需要修改
			//10 0需要修改 00 0不需要修改
			if board[i][j] == 1 {
				if live < 2 {
					board[i][j] = 11
				} else if live == 2 || live == 3 {
					board[i][j] = 1
				} else if live > 3 {
					board[i][j] = 11
				}
			} else if board[i][j] == 0 {
				if live == 3 {
					board[i][j] = 10
				}
			}
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 11 {
				board[i][j] = 0
			} else if board[i][j] == 10 {
				board[i][j] = 1
			}
		}
	}

	fmt.Println("")
}