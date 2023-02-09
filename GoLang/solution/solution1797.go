package solution

type AuthenticationManager struct {
	m          map[string]int
	timeTolive int
}

func Constructor1797(timeToLive int) AuthenticationManager {
	return AuthenticationManager{make(map[string]int, 0), timeToLive}
}

func (this *AuthenticationManager) Generate(tokenId string, currentTime int) {
	this.m[tokenId] = currentTime + this.timeTolive
}

func (this *AuthenticationManager) Renew(tokenId string, currentTime int) {
	_, ok := this.m[tokenId]
	if ok {
		deadTime := this.m[tokenId]
		if deadTime <= currentTime {
			return
		} else {
			deadTime = currentTime + this.timeTolive
			this.m[tokenId] = deadTime
		}
	}
}

func (this *AuthenticationManager) CountUnexpiredTokens(currentTime int) int {
	allToken := this.m
	count := 0
	for _, v := range allToken {
		if v > currentTime {
			count++
		}
	}
	return count
}
