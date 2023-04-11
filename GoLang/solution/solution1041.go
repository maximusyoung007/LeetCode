package solution

func IsRobotBounded(instructions string) bool {
	x, y := 0, 0
	//表示下一步往哪个方向走
	index := 0
	//下一步走的地方，分别表示北、东、南、西
	nextMove := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
	for i := 0; i < len(instructions); i++ {
		if instructions[i] == 'L' {
			index--
			if index < 0 {
				index = 3
			}
		} else if instructions[i] == 'R' {
			index++
			if index > 3 {
				index = 0
			}
		} else {
			x += nextMove[index][0]
			y += nextMove[index][1]
		}
	}
	//回到原点或者不面朝北方
	return (x == 0 && y == 0) || index != 0
}
