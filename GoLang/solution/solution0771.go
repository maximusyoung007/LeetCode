package solution

import (
	"fmt"
	"strings"
)

func numJewelsInStones(jewels string, stones string) int {
	count := 0
	i := 0
	for i < len(stones) {
		t := stones[i : i+1]
		if strings.Contains(jewels, t) {
			count++
		}
		i++
	}
	return count
}

func Test0771() {
	//jewels := "aA"
	//stones := "aAAbbbb"
	jewels := "z"
	stones := "ZZ"
	fmt.Println(numJewelsInStones(jewels, stones))
}
