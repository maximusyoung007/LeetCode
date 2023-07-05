package solution

import "fmt"

func kItemsWithMaximumSum(numOnes int, numZeros int, numNegOnes int, k int) int {
	res := 0
	for k > 0 {
		if numOnes > 0 {
			numOnes--
			res++
		} else if numZeros > 0 {
			numZeros--
		} else if numNegOnes > 0 {
			numNegOnes--
			res--
		}
		k--
	}
	return res
}

func Test2600() {
	numOnes := 3
	numZeros := 2
	numNegOnes := 0
	k := 4
	fmt.Println(kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k))
}
