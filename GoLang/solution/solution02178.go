package solution

import "fmt"

func maximumEvenSplit(finalSum int64) []int64 {
	if finalSum%2 != 0 {
		return []int64{}
	}
	res := make([]int64, 0)
	var i, total int64
	total = 0
	for i = 2; i <= finalSum; i += 2 {
		total += i
		if total == finalSum {
			res = append(res, i)
			return res
		}
		//如果剩下的值小于等于当前值，则会造成重复
		if finalSum-total <= i {
			total -= i
		} else {
			res = append(res, i)
		}

	}
	return []int64{}
}

func Test02178() {
	//res := maximumEvenSplit(12)
	//res := maximumEvenSplit(7)
	//res := maximumEvenSplit(4)
	res := maximumEvenSplit(6)
	fmt.Println(res)
}
