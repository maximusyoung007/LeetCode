/**
 * @param {number} n
 * @return {number}
 */
var countPrimes = function (n) {
    var primes = new Array();
    for(var i = 2;i < n;i++) {
        for(var j = 2 * i;j <= n;j += i) {
            primes[j] = 1;
        }
    }
    var count = 0;
    for(var i = 2;i < n;i++) {
        if(primes[i] != 1) {
            count++;
        }
    }
    return count;
};

//test
console.log(countPrimes(10));
console.log(countPrimes(2));