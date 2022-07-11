package solution

type MagicDictionary struct {
	dis []string
}


func Constructor0676() MagicDictionary {
	return MagicDictionary{}
}


func (this *MagicDictionary) BuildDict(dictionary []string)  {
	this.dis = dictionary
}


func (this *MagicDictionary) Search(searchWord string) bool {
	dis := this.dis
	for _, val := range dis {
		if len(val) == len(searchWord) {
			count := 0
			for i := 0; i < len(val); i++ {
				if val[i] != searchWord[i] {
					count++
				}
			}
			if count == 1 {
				return true
			}
		}
	}
	return false
}