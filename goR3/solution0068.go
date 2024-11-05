package main

import (
	"strings"
)

func FullJustify(words []string, maxWidth int) []string {
	//用来记录每一行字母个数
	lineLength := 0
	//用来记录每一行空格个数
	spaceNum := 0
	//每行单词个数
	wordNum := 0
	//如果单词数大于一个，则依次遍历每两个单词中间的位置，空格数+1，直到空格数耗尽
	//如果单词数等于一个，则单词直接加上空格数即可
	j := 0
	res := make([]string, 0)
	for i := 0; i < len(words); i++ {
		word := words[i]
		if lineLength+len(word)+1 <= maxWidth || lineLength+len(word) <= maxWidth {
			lineLength = lineLength + len(word) + 1
			wordNum++
			//如果是最后一个
			if i == len(words)-1 {
				spaceNum = maxWidth - lineLength + wordNum

				//如果一行只有一个单词
				if wordNum == 1 {
					ts := words[i]
					for s := 0; s < spaceNum; s++ {
						ts = ts + " "
					}
					res = append(res, ts)
				} else {
					t := i
					ts := ""
					tsArray := make([]string, wordNum)

					k := 0
					for j <= t {
						tsArray[k] = words[j]
						k++
						j++
					}

					for k = 0; k < len(tsArray)-1; k++ {
						if spaceNum <= 0 {
							break
						} else {
							tsArray[k] = tsArray[k] + " "
							if k == len(tsArray)-2 {
								k = -1
							}
							spaceNum--
						}
					}

					for _, s := range tsArray {
						ts = ts + s
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

			//如果一行只有一个单词
			if wordNum == 1 {
				ts := words[i-1]
				for s := 0; s < spaceNum; s++ {
					ts = ts + " "
				}
				res = append(res, ts)
				lineLength = 0
				spaceNum = 0
				wordNum = 0
				j = i
				i--
			} else {
				t := i - 1
				ts := ""
				tsArray := make([]string, wordNum)

				k := 0
				for j <= t {
					tsArray[k] = words[j]
					k++
					j++
				}

				for k = 0; k < len(tsArray)-1; k++ {
					if spaceNum <= 0 {
						break
					} else {
						tsArray[k] = tsArray[k] + " "
						if k == len(tsArray)-2 {
							k = -1
						}
						spaceNum--
					}
				}

				for _, s := range tsArray {
					ts = ts + s
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

	//最后一行特殊处理
	lastLine := res[len(res)-1]
	w := strings.Fields(lastLine)
	// 用单个空格连接单词，并在末尾添加四个空格
	newString := strings.Join(w, " ")
	sub := maxWidth - len(newString)

	for i := 0; i < sub; i++ {
		newString = newString + " "
	}

	res[len(res)-1] = newString

	return res

}
