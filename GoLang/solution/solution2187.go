package solution

import "sort"

func MinimumTime(time []int, totalTrips int) int64 {
	sort.Ints(time)
	left, right := 0, totalTrips*time[0]
	for left < right {
		mid := (left + right + 1) / 2
		if canFinish(time, mid, totalTrips) {
			right = mid - 1
		} else {
			left = mid
		}
	}
	return int64(right + 1)
}

func canFinish(time []int, t int, totalTrips int) bool {
	sum := 0
	for _, v := range time {
		sum += t / v
	}
	return sum >= totalTrips
}
