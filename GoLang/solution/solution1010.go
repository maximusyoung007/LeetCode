package solution

/*
(a+b)mod60 = 0
(a mod 60 + b mod 60 ) mod 60 = 0
记x = a mod 60,
y = b mod 60
则(x + y) mod 60 == 0
y = (60 - x) mod 60

记录 余数x出现的次数
如果存在y = (60-x) mod 60
加到答案中
并将x在数组中出现次数+1
思路可参考0001-两数之和
*/
func NumPairsDivisibleBy60(time []int) int {
	count := make([]int, 60)
	res := 0
	for _, t := range time {
		t %= 60
		y := (60 - t) % 60
		res += count[y]
		count[t]++
	}
	return res
}
