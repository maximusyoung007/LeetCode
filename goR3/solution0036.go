package main

func IsValidSudoku(board [][]byte) bool {
	//记录每一行
	row := [9][9]int{}
	//记录每一列
	line := [9][9]int{}
	//记录每一个区域
	area := [3][3][9]int{}

	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			num := board[i][j] - '0'

			if num >= 1 && num <= 9 {
				row[i][num-1] += 1
				if row[i][num-1] > 1 {
					return false
				}

				line[j][num-1] += 1
				if line[j][num-1] > 1 {
					return false
				}

				area[i/3][j/3][num-1] += 1
				if area[i/3][j/3][num-1] > 1 {
					return false
				}
			}

		}
	}

	return true
}
