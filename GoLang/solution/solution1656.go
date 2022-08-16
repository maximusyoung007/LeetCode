package solution

type OrderedStream struct {
	num []string
	ptr int
}

func Constructor1656(n int) OrderedStream {
	return OrderedStream{make([]string, n+1), 1}
}

func (this *OrderedStream) Insert(idKey int, value string) []string {
	this.num[idKey] = value
	t := this.ptr
	for this.ptr < len(this.num) && this.num[this.ptr] != "" {
		this.ptr += 1
	}
	return this.num[t:this.ptr]
}

//func sortMap(m map[string]int)  {
//	newMap = make([]string, 0)
//	for k, _ := range m {
//		newMap
//	}
//}
