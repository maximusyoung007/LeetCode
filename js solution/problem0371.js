/**
 * @param {number} a
 * @param {number} b
 * @return {number}
 */
var getSum = function(a, b) {
    if((a & b) == 0)
        return a | b
    return getSum(a ^ b,(a & b) << 1)
}

//test
console.log(getSum(1,2))
console.log(getSum(12,7))