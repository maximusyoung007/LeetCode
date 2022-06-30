package solution

const mod int = 1e9 + 7

func NumPrimeArrangements(n int) int {
	primes := 0
	composite := 0
	for i := 1; i <= n; i++ {
		if isPrime(i) {
			primes++;
		} else {
			composite++;
		}
	}
	return factor(primes) * factor(composite) % mod
}

func isPrime(n int) bool{
	if n == 1 || n == 0 {
		return false
	}
	for i := 2; i * i <= n; i++ {
		if n % i == 0 {
			return false
		}
	}
	return true
}

func factor(n int) int{
	res := 1
	for i := 1; i <= n; i++ {
		res *= i
		res %= mod
	}
	return res
}
