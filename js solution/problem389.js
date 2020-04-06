/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
var findTheDifference = function(s, t) {
    var sum = 0
    for (var i = 0;i < t.length;i++) {
        var tem = t.charCodeAt(i)
        sum += tem
    }
    for (var i = 0;i < s.length;i++) {
        var tem = s.charCodeAt(i)
        sum -= tem
    }
    return String.fromCharCode(sum)
}

//test
var s = "abcd"
var t = "abcde"
console.log(findTheDifference(s,t))

var s1 = "a"
var t1 = "aa"
console.log(findTheDifference(s1,t1))