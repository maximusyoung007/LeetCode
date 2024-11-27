package main

func Rotate1(matrix [][]int) {
	//matrix[i][j]
	//matrix[n−1−j][i]
	//matrix[n−1−i][n−1−j]
	//matrix[j][n−1−i]

	n := len(matrix)

	x := n / 2
	var y int
	if n%2 == 0 {
		y = n / 2
	} else {
		y = n/2 + 1
	}

	for i := 0; i < x; i++ {
		for j := 0; j < y; j++ {
			t := matrix[i][j]
			matrix[i][j] = matrix[n-1-j][i]
			matrix[n-1-j][i] = matrix[n-1-i][n-1-j]
			matrix[n-1-i][n-1-j] = matrix[j][n-1-i]
			matrix[j][n-1-i] = t
		}
	}
}
