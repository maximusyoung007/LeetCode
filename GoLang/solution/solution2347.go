package solution

func BestHand(ranks []int, suits []byte) string {
	rankM := make(map[int]int, 0)
	suitM := make(map[byte]int, 0)
	for i := 0; i < len(ranks); i++ {
		_, ok1 := rankM[ranks[i]]
		_, ok2 := suitM[suits[i]]
		if ok1 {
			rankM[ranks[i]] += 1
		} else {
			rankM[ranks[i]] = 1
		}

		if ok2 {
			suitM[suits[i]] += 1
		} else {
			suitM[suits[i]] = 1
		}
	}
	if len(suitM) == 1 {
		return "Flush"
	}
	res := 0
	for _, v := range rankM {
		if v == 3 || v == 4 {
			res = 3
		} else if v == 2 {
			if res != 3 {
				res = 2
			}
		}
	}
	if res == 3 {
		return "Three of a Kind"
	} else if res == 2 {
		return "Pair"
	}
	return "High Card"
}
