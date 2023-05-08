package solution

/*
*
1、三枚棋子连续放置，不需要移动，最小移动次数为0
2、其中两枚连续，或者间隔为1，只需要对另一枚石子移动一次，最小移动次数为1
3、对于其他情况，移到情况2，移动一次，加上情况2的一次，一共最少要移动两次
移动最多的距离即为z和x的距离之和
*/
func NumMovesStones(a int, b int, c int) []int {
	res := make([]int, 2)
	if a > b {
		t := a
		a = b
		b = t
	}
	if b > c {
		t := b
		b = c
		c = t
	}
	if a > b {
		t := a
		a = b
		b = t
	}
	if b-a == 1 && c-b == 1 {
		res[0] = 0
	} else if b-a == 1 || c-b == 1 || b-a == 2 || c-b == 2 {
		res[0] = 1
	} else {
		res[0] = 2
	}

	res[1] = c - a - 2
	return res
}
