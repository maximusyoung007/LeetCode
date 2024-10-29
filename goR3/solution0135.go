package main

func Candy(ratings []int) int {
	n := len(ratings)

	res := 1
	//递减序列长度
	num := 1
	//上一位
	pre := 1
	//递减序列第一位
	first := 0

	//如果是递增序列，则后一个比前一个+1
	//如果是递减序列，根据first是否大于num,判断是否要把递增序列的每一位+1
	//如果相等，则后一位默认为1
	//递增或者相等时，当前位默认为递增序列的第一位，有nums=1，first=pre,如果向后遍历发现不是递减序列，则刷新这两个值

	for i := 1; i < n; i++ {
		if ratings[i] > ratings[i-1] {
			pre += 1
			res += pre
			num = 1
			first = pre
		} else if ratings[i] < ratings[i-1] {
			//递减序列长度+1
			if pre > 1 {
				res += 1
				pre = 1
				num++
			} else {
				num++
				//记录递减序列的第一个为first，如果first>=num,则first，fisrt-1,first-2..这样的序列一定满足，first不需要增加,否则第一个也要+1
				//如first=5, 向后遍历依次是
				//5,1
				//5,2,1
				//5,3,2,1
				//5,4,3,2,1此时first=num,fisrt不需要+1，3,2,1,0->4,3,2,1每一位+1
				//num=6,大于5，则fisrt也要+1了
				if first >= num {
					res += num - 1
				} else {
					res += num
					first++
				}
			}
		} else if ratings[i] == ratings[i-1] {
			//如果后一位等于前一位，后一位从1开始
			res += 1
			pre = 1
			first = pre
			num = 1
		}
	}

	return res
}
