package solution

func candy(ratings []int) int {
	//先从左往右遍历，如果右边的比左边的大，则右边的=左边+1，保证右边的一定大于左边的
	//再从右往左遍历，如果左边的比右边的大，且左边糖果数小于右边的，则左边=右边+1，保证左边的一定大于右边的
	length := len(ratings)
	candies := make([]int, length)
	for i := 0; i < length; i++ {
		candies[i] = 1
	}

	for i := 0; i < length; i++ {
		j := i + 1
		if 
	}
}
