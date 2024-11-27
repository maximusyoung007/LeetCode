package main

func FindSubstring(s string, words []string) []int {
	//方法一 dfs求全排列，再在s中查找 超时
	//totalLen := 0
	//for i := 0; i < len(words); i++ {
	//	totalLen += len(words[i])
	//}
	//
	//if totalLen > len(s) {
	//	return []int{}
	//}
	//
	//visited := make([]bool, len(words))
	//
	//permutation := make(map[string]int)
	//dfs := func(i int, num int, words []string, r string, visited []bool) {}
	//dfs = func(i int, num int, words []string, r string, visited []bool) {
	//
	//	visited[i] = true
	//	r = r + words[i]
	//	num++
	//
	//	if num == len(words) {
	//		permutation[r] = 1
	//		visited[i] = false
	//		return
	//	}
	//
	//	for i := 0; i < len(words); i++ {
	//		if !visited[i] {
	//			dfs(i, num, words, r, visited)
	//			visited[i] = false
	//		}
	//	}
	//}
	//for i := 0; i < len(words); i++ {
	//	r := ""
	//	if !visited[i] {
	//		dfs(i, 0, words, r, visited)
	//		visited[i] = false
	//	}
	//}
	//
	//res := make([]int, 0)
	//
	//i, j := 0, totalLen-1
	//for j < len(s) {
	//	_, ok := permutation[s[i:j+1]]
	//
	//	if ok {
	//		res = append(res, i)
	//	}
	//	i++
	//	j++
	//}
	//
	//return res

	res := make([]int, 0)
	wordsMap := make(map[string]int)
	wordLength := 0
	step := 0
	if len(words) != 0 {
		step = len(words[0])
	}

	for _, word := range words {
		wordLength += len(word)
		_, ok := wordsMap[word]
		if !ok {
			wordsMap[word] = 1
		} else {
			wordsMap[word]++
		}
	}

	//移动左指针有三种情况
	//1、完全匹配，左指针往后移动一个单词
	//2、有错误单词，左指针移动到错误单词之后
	//3、有多的单词，左指针移动到第一个多的单词之后
	var i, j int

	//多起点，step个start，因为从0出发只能判断(step-1)倍数位置的数
	for start := 0; start < step; start++ {
		i = start
		j = i + step

		nums := 0
		map2 := make(map[string]int)

		//t在截取单词时作为开始下标
		t := i
		length := len(s)
		for j <= length {
			tw := s[t:j]
			_, ok := wordsMap[tw]
			nums += step
			if ok {
				_, ok2 := map2[tw]
				if !ok2 {
					map2[tw] = 1
				} else {
					map2[tw]++
				}

				//有多的单词
				if map2[tw] > wordsMap[tw] {
					for map2[tw] > wordsMap[tw] {
						tw2 := s[i : i+step]
						map2[tw2]--
						if map2[tw2] == 0 {
							delete(map2, tw2)
						}
						nums -= step
						i += step
					}
					//需要移动右指针，放在后面的if else中移动
				}

				//如果字串和单词数组长度相等
				if nums == wordLength {
					isRight := true
					for key, value := range wordsMap {
						_, ok3 := map2[key]
						if ok3 && map2[key] == value {
							continue
						} else {
							isRight = false
							break
						}
					}

					if isRight {
						res = append(res, i)
					}
					tw = s[i : i+step]
					map2[tw]--
					if map2[tw] == 0 {
						delete(map2, tw)
					}
					nums -= step
					t = j
					i += step
					j += step
				} else {
					//右指针正常向后移动
					t = j
					j += step
				}
			} else {
				//单词在数组中不存在
				for i < j {
					tm := s[i : i+step]
					delete(map2, tm)
					nums -= step
					i += step
				}
				i = j
				t = j
				j += step
			}
		}
	}

	return res
}
