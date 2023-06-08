package solution

func MinSpeedOnTime(dist []int, hour float64) int {
	left, right := 0, 1e7
	res := -1
	for left < int(right) {
		mid := (left + int(right) + 1) / 2
		if canArrive(dist, mid, hour) {
			right = float64(mid - 1)
			res = mid
		} else {
			left = mid
		}
	}
	return res
}

func canArrive(dist []int, speed int, hour float64) bool {
	var sum float64
	sum = 0
	for i := 0; i < len(dist); i++ {
		if dist[i]%speed == 0 {
			sum += float64(dist[i] / speed)
		} else {
			if i != len(dist)-1 {
				sum += float64(dist[i]/speed + 1)
			} else {
				sum += float64(dist[i]) / float64(speed)
			}
		}
		if sum > hour {
			return false
		}
	}
	return sum <= hour
}
