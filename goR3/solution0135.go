package main

func Candy(ratings []int) int {
	//如果是递增序列，则后一个比前一个+1
	//如果是递减序列，如果前一个-1大于0，则直接加入，否则把递减序列所有的+1
	n := len(ratings)

	res := 1
	num := 1
	pre := 1

	for i := 1; i < n; i++ {
		if ratings[i] > ratings[i-1] {
			pre += 1
			res += pre
			num = 1
		} else if ratings[i] <= ratings[i-1] {
			//递减序列长度+1
			num++
			if ratings[i-1] > 1 {
				pre = pre - 1
				res += pre
			} else {
				//递减序列的每一个位置都+1
				res += num
			}

		}
	}

	return res
}
