/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    const set = new Set()
    while(n != 1) {
        if(set.has(n)) 
            return false
        else 
            set.add(n)
        n = cal(n)
    }
    return true
}
function cal(n) {
    var result = 0,c = 0
    while(n > 0) {
        c = parseInt(n % 10)
        result += c * c
        n = Math.floor(n / 10)
    }
    return result
}

//test
//console.log(cal(18))
console.log(isHappy(19))
console.log(isHappy(18))