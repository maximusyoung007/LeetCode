package solution

// 滑动窗口
func MinimumRecolors(blocks string, k int) int {
	start, end := 0, k
	min := 0
	white := 0
	//初始窗口值
	for i := start; i < end; i++ {
		if blocks[i] == 'W' {
			white++
		}
	}
	min = white
	for i, j := 1, k; j < len(blocks); i, j = i+1, j+1 {
		//窗口的前一个是白
		if blocks[i-1] == 'W' {
			white--
		}
		//窗口的最后一个是白
		if blocks[j] == 'W' {
			white++
		}
		if white < min {
			min = white
		}
	}
	return min
}
