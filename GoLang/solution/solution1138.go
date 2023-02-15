package solution

import "strings"

// 各个字母位置固定，因此直接模拟移动即可，z的位置需要特殊处理
func AlphabetBoardPath(target string) string {
	var build strings.Builder
	var fromX int
	var fromY int
	for i := 0; i < len(target); i++ {
		c := target[i]
		toX := int((c - 'a') / 5)
		toY := int((c - 'a') % 5)
		if fromX == toX && fromY == toY {
			build.WriteString("!")
			continue
		}
		//如果z是起点，先向上移动一步
		if fromX == 5 && fromY == 0 {
			fromX--
			build.WriteString("U")
		}

		//如果z是终点，先移动y
		if toY > fromY {
			for fromY < toY {
				build.WriteString("R")
				fromY++
			}
		} else {
			for fromY > toY {
				build.WriteString("L")
				fromY--
			}
		}

		if toX > fromX {
			for fromX < toX {
				build.WriteString("D")
				fromX++
			}
		} else {
			for fromX > toX {
				build.WriteString("U")
				fromX--
			}
		}

		build.WriteString("!")
	}
	return build.String()
}
