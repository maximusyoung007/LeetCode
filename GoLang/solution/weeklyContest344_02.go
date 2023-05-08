package solution

type FrequencyTracker struct {
	m map[int]int
	//用来记录频率
	fre map[int]int
}

func Constructor34402() FrequencyTracker {
	return FrequencyTracker{make(map[int]int, 0), make(map[int]int, 0)}
}

func (this *FrequencyTracker) Add(number int) {
	//当前数的频率为3，增加后，频率为3的数就减少了一个
	this.fre[this.m[number]]--
	this.m[number]++
	_, ok := this.fre[this.m[number]]
	//存在频率为this.m[number]的
	if !ok {
		this.fre[this.m[number]] = 1
	} else {
		this.fre[this.m[number]]++
	}
}

func (this *FrequencyTracker) DeleteOne(number int) {
	_, ok := this.m[number]
	if ok && this.m[number] > 0 {
		//假设number的频率是3，删除后，频率为3的就减少了一个
		this.fre[this.m[number]]--
		this.m[number]--
	}
	_, ok = this.fre[this.m[number]]
	if !ok {
		this.fre[this.m[number]] = 1
	} else {
		this.fre[this.m[number]]++
	}
}

func (this *FrequencyTracker) HasFrequency(frequency int) bool {
	_, ok := this.fre[frequency]
	if ok && this.fre[frequency] != 0 {
		return true
	}
	return false
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(number);
 * obj.DeleteOne(number);
 * param_3 := obj.HasFrequency(frequency);
 */
