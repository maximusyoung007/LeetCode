/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var rangeBitwiseAnd = function (m, n) {
    var k = 0;
    while(m != n) {
        m = m >> 1;
        n = n >> 1;
        k++;
    }
    return m << k;
};

//test
console.log("result" + rangeBitwiseAnd(5,7))
console.log(rangeBitwiseAnd(0,1))