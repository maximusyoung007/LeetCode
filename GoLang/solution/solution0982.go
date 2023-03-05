package solution

/*
*
x,y,z
count[i] 记录第x&y有多少个
*/
func CountTriplets(nums []int) int {
	res := 0
	count := make([]int, 1<<16)
	for _, numI := range nums {
		for _, numJ := range nums {
			count[numI&numJ]++
		}
	}

	for _, numK := range nums {
		//这里的i即为之前x&y结果，count[i]为结果为x&y的数量
		for i := 0; i < (1 << 16); i++ {
			if numK&i == 0 {
				res += count[i]
			}
		}
	}
	return res
}
