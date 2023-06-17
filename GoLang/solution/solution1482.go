package solution

func MinDays(bloomDay []int, m int, k int) int {
	maxN := 0
	left, right := 0, 0
	for i := 0; i < len(bloomDay); i++ {
		if bloomDay[i] > right {
			right = bloomDay[i]
			maxN = bloomDay[i]
		}
	}
	right++
	for left < right {
		day := (left + right + 1) / 2
		if enoughFlower(bloomDay, m, k, day) {
			right = day - 1
		} else {
			left = day
		}
	}
	if right < 0 || right > maxN {
		return -1
	}
	return right + 1
}

//每一天，用一个大小为k的滑动窗口，判断满足条件的滑动窗口个数是否等于m,即为可以种的花的数量
func enoughFlower(bloomDay []int, m int, k int, day int) bool {
	left, right := 0, k-1
	count := 0
	sum := 0
	i := 0
	for right < len(bloomDay) {
		i = left
		for i <= right {
			if day >= bloomDay[i] {
				count++
				i++
			} else {
				//如果滑动窗口有一个没开花的，就从下一个滑动窗口重新开始
				left = i + 1
				right = left + k - 1
				count = 0
				break
			}
		}
		if count == k {
			sum++
			left = right + 1
			right = left + k - 1
			count = 0
		}
	}
	return sum >= m
}
