package solution

func HardestWorker(n int, logs [][]int) int {
	max := 0
	res := 0
	last := 0
	for k, log := range logs {
		if k == 0 {
			if log[1]-0 > max {
				max = log[1] - 0
				res = log[0]
			}
		} else {
			if log[1]-last > max {
				max = log[1] - last
				res = log[0]
			} else if log[1]-last == max {
				if log[0] < res {
					res = log[0]
				}
			}
		}
		last = log[1]
	}
	return res
}
