package solution

func ShipWithinDays(weights []int, days int) int {
	left, right := 0, 0
	for _, v := range weights {
		right += v
	}
	for left < right {
		mid := (left + right + 1) / 2
		if enough(weights, mid, days) {
			right = mid - 1
		} else {
			left = mid
		}
	}
	return right + 1
}

func enough(weights []int, weigh int, days int) bool {
	i, w, d := 0, 0, 0
	for w < weigh && i < len(weights) {
		w += weights[i]
		if w > weigh {
			d++
			w = 0
		} else if w == weigh {
			d++
			w = 0
			i++
		} else {
			i++
		}
		if d > days {
			return false
		}
	}
	if w != 0 {
		d++
	}
	return d <= days
}
