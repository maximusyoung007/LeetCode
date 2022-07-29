package solution

func ValidSquare(p1 []int, p2 []int, p3 []int, p4 []int) bool {
	distances := make(map[int]int, 0)
	distances[dis(p1, p2)] = 0
	distances[dis(p1, p3)] = 0
	distances[dis(p1, p4)] = 0
	distances[dis(p2, p3)] = 0
	distances[dis(p2, p4)] = 0
	distances[dis(p3, p4)] = 0

	if len(distances) != 2 {
		return false
	}

	d := make([]int, 0)
	for k, _ := range distances {
		d = append(d, k)
	}
	if d[0] > d[1] {
		return d[0] == 2*d[1]
	} else {
		return d[1] == 2*d[0]
	}
}

func dis(p1 []int, p2 []int) int {
	return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1])
}
