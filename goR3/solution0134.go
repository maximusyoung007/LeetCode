package main

func CanCompleteCircuit(gas []int, cost []int) int {
	//从i等于0开始枚举
	//i向后走，如果当前节点剩余的油小于需要的，则表示走不到下一个节点，假设是节点j
	//假设i和j中有一个节点k,i无法走到j，则k肯定也无法走到j,因为i能走到k,到k的时候剩余油量一定大于等于0
	//从k出发，“之前”的剩余油量为0
	//所以下次直接从j开始继续往下走
	n := len(gas)
	for i := 0; i < n; {
		rest := 0
		var j int
		for j = 0; j < n; j++ {
			//k表示走到j实际对应的是哪一个加油站，便于计算是否可以往下走
			k := (i + j) % n
			//走不到j+1,下一次从j+1开始走
			if rest+gas[k]-cost[k] < 0 {
				//i大于n，则表示所有点都考虑过了，可以结束了
				i = i + j + 1
				break
			}
			//往下一步走剩余的油
			rest = rest + gas[k] - cost[k]
		}
		//j刚好走完一圈
		if j == n {
			return i
		}
	}

	return -1
}
