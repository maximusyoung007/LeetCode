package solution

func distanceBetweenBusStops(distance []int, start int, destination int) int {
	if start > destination {
		start, destination = destination, start
	}
	sum, sum1 := 0, 0
	for i := 0; i < len(distance); i++ {
		if i >= start && i < destination {
			sum1 += distance[i]
		}
		sum += distance[i]
	}
	sum2 := sum - sum1
	if sum2 <= sum1 {
		return sum2
	}
	return sum1
}
