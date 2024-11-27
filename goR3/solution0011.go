package main

func MaxArea(height []int) int {
	//i,j之间可容纳水，移动i,j中较小的那个
	i, j := 0, len(height)-1

	maxRes, minSide := 0, 0
	calArea := func(i int, j int, minSide int) int {
		if height[minSide]*(j-i) > maxRes {
			return height[minSide] * (j - i)
		} else {
			return maxRes
		}
	}
	for i < j {

		if height[i] > height[j] {
			minSide = j
			maxRes = calArea(i, j, minSide)
			j--
		} else {
			minSide = i
			maxRes = calArea(i, j, minSide)
			i++
		}

	}

	return maxRes
}
