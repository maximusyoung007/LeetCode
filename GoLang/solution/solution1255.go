package solution

/*
*

	n=len(words)
	s， n位数字，每位表示当前位的单词是否使用
	count表示letter的字母的数目
	循环s,用wordCounts表示s中字母使用次数，
	如果wordCounts里每个字母次数都小于counts,即表示成功
*/
func MaxScoreWords(words []string, letters []byte, score []int) int {
	res := 0
	counts := make(map[int]int)
	for i := 0; i < len(letters); i++ {
		counts[int(letters[i]-'a')]++
	}
	for s := 1; s < (1 << len(words)); s++ {
		wordCounts := make(map[int]int, 0)
		for k := 0; k < len(words); k++ {
			// 0000 & 1 << k == 0
			if s&(1<<k) != 0 {
				for j := 0; j < len(words[k]); j++ {
					wordCounts[int(words[k][j]-'a')]++
				}
			}
		}
		sum := 0
		isOk := true
		for i := 0; i < 26; i++ {
			if wordCounts[i] <= counts[i] {
				sum += wordCounts[i] * score[i]
			} else {
				//如果其中有一个字母不行，就表示当前这个s不行
				isOk = false
			}
		}
		if isOk && sum > res {
			res = sum
		}
		sum = 0
		isOk = true
	}
	return res
}
