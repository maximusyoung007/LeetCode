/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
var reverseString = function(s) {
    var left = 0,right = s.length - 1
    while(left < right) {
        var temp = s[left]
        s[left] = s[right]
        s[right] = temp
        left++
        right--
    }
};

//test
var s = ['h','e','l','l','o']
reverseString(s)
console.log(s)
var s1 = ["H","a","n","n","a","h"]
reverseString(s1)
console.log(s1)