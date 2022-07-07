package solution

import (
	"math"
	"strings"
)

func ReplaceWords(dictionary []string, sentence string) string {
	sentenceArr := strings.Split(sentence, " ")
	min := math.MaxInt32
	for i := 0; i < len(sentenceArr); i++ {
		s := sentenceArr[i]
		for _, d := range dictionary {
			if strings.HasPrefix(s, d) && len(d) < min {
				sentenceArr[i] = d
				min = len(d)
			}
		}
		min = math.MaxInt32
	}
	var build strings.Builder
	for _, v := range sentenceArr {
		build.WriteString(v)
		build.WriteString(" ")
	}
	return strings.TrimSuffix(build.String(), " ")

}
