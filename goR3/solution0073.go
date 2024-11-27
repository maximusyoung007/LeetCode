package main

func SetZeroes(matrix [][]int) {

	line, row := false, false

	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {

			if matrix[i][j] == 0 {
				if i == 0 {
					line = true
				}
				if j == 0 {
					row = true
				}
				//第i行，第j列为0
				matrix[i][0] = 0
				matrix[0][j] = 0
			}
		}
	}

	for i := 1; i < len(matrix); i++ {
		if matrix[i][0] == 0 {
			for j := 1; j < len(matrix[0]); j++ {
				matrix[i][j] = 0
			}
		}
	}

	for j := 1; j < len(matrix[0]); j++ {
		if matrix[0][j] == 0 {
			for i := 1; i < len(matrix); i++ {
				matrix[i][j] = 0
			}
		}
	}

	if line {
		for j := 0; j < len(matrix[0]); j++ {
			matrix[0][j] = 0
		}
	}

	if row {
		for i := 0; i < len(matrix); i++ {
			matrix[i][0] = 0
		}
	}

}
