package solution

func AsteroidCollision(asteroids []int) (res []int) {
	for _, asteroid := range asteroids {
		alive := true
		if asteroid > 0 {
			res = append(res, asteroid)
		} else {
			for alive && len(res) > 0 && res[len(res)-1]*asteroid < 0 {
				t := asteroid * -1
				if t < res[len(res)-1] {
					alive = false
				} else if t == res[len(res)-1] {
					alive = false
					res = res[:len(res)-1]
				} else {
					res = res[:len(res)-1]
				}
			}
			if alive {
				res = append(res, asteroid)
			}
		}
	}
	return res
}
