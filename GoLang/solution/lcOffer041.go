package solution

type MovingAverage struct {
	num []int
	size int
	sum float64
}


/** Initialize your data structure here. */
func ConstructorOffer041(size int) MovingAverage {
	return MovingAverage{make([]int, 0), size, 0}
}


func (this *MovingAverage) Next(val int) float64 {
	length := len(this.num)

	if length >= this.size {
		t := this.num[0]
		this.sum -= float64(t)
		this.num = this.num[1:]
		length = this.size
	} else {
		length++
	}
	this.num = append(this.num, val)
	this.sum += float64(val)
	return this.sum / float64(length)
}

