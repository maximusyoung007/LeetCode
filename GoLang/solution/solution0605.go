package solution

func CanPlaceFlowers(flowerbed []int, n int) bool {
	i := 0

	for i < len(flowerbed) && n > 0 {
		if flowerbed[i] == 1 {
			i += 2
		} else {
			if i == len(flowerbed)-1 || flowerbed[i+1] == 0 {
				i += 2
				n--
			} else {
				i += 3
			}
		}
	}
	return n == 0
}
