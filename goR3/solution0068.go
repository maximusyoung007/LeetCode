package main 

func FullJustify(words []string, maxWidth int) []string {
	//用来记录每一行字母个数
	lineLength := 0
	//用来记录每一行空格个数
	spaceNum := 0
	//每行单词个数
	wordNum := 0
	j := 0
	res := make([]string, 0)
    for i := 0; i < len(words); i++ { 
		word := words[i]
		if lineLength + len(word) + 1 <= maxWidth {
			lineLength = lineLength + len(word) + 1
			wordNum++
			if i == len(words) - 1 {
				spaceNum = maxWidth - lineLength + wordNum
				//每个单词中间应该有多少个空格
				eachLength := 0
				if wordNum > 1 {
					eachLength = spaceNum / (wordNum-1)
				} else {
					eachLength = spaceNum
				}
				//空格是否可以均匀分布
				if eachLength * (wordNum-1) == spaceNum {
					t := i
					ts := ""
					if wordNum > 1 {
						wordNum--
					}
					for j <= t {
						ts = ts + words[j]
						if wordNum > 0 {
							for e := 0; e < eachLength; e++ {
								ts = ts + " "
							}
							wordNum--
						}
						j++
					}
					res = append(res, ts)
					
					lineLength = 0
					spaceNum = 0
					wordNum = 0
					j = i
				} else {
					left := spaceNum - eachLength * (wordNum-1)
					t := i
					ts := ""
					if wordNum > 1 {
						wordNum -= 2
					}
					for j <= t {
						ts = ts + words[j]
						if wordNum > 0 {
							for e := 0; e < eachLength; e++ {
								ts = ts + " "
							}
							wordNum--
						} else if wordNum == 0 {
							for e := 0; e < left; e++ {
								ts = ts + " "
							} 
							wordNum--
						}
						j++
					}
					res = append(res, ts)

					lineLength = 0
					spaceNum = 0
					wordNum = 0
					j = i
				}
			}
		} else {
			spaceNum = maxWidth - lineLength + wordNum
			//每个单词中间应该有多少个空格
			eachLength := 0
			if wordNum > 1 {
				eachLength = spaceNum / (wordNum-1)
			} else {
				eachLength = spaceNum
			}
			//空格是否可以均匀分布
			if eachLength * (wordNum-1) == spaceNum {
				t := i-1
				ts := ""
				if wordNum > 1 {
					wordNum--
				}
				for j <= t {
					ts = ts + words[j]
					if wordNum > 0 {
						for e := 0; e < eachLength; e++ {
							ts = ts + " "
						}
						wordNum--
					}
					j++
				}
				res = append(res, ts)
				
				lineLength = 0
				spaceNum = 0
				wordNum = 0
				j = i
				i--
			} else {
				left := spaceNum - eachLength * (wordNum-1)
				t := i-1
				ts := ""
				if wordNum > 1 {
					wordNum -= 2
				}
				spaceArray := make([]int, wordNum)

				for j <= t {
					ts = ts + words[j]
					if wordNum > 0 {
						for e := 0; e < eachLength; e++ {
							ts = ts + " "
						}
						wordNum--
					} else if wordNum == 0 {
						for e := 0; e < left; e++ {
							ts = ts + " "
						} 
						wordNum--
					}
					j++
				}
				res = append(res, ts)

				lineLength = 0
				spaceNum = 0
				wordNum = 0
				j = i
				i--
			}
		}
	}

	return res

}