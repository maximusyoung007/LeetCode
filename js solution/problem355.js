/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    var left = 0,right = s.length - 1
    var result_ = s.split('')
    while(left < right) {
        var c1 = result_[left]
        var c2 = result_[right]
        if(isVowel(c1) && isVowel(c2)) {
            var temp = result_[left]
            result_[left] = result_[right]
            result_[right] = temp
            left++
            right--
        } else if(isVowel(c1) && !isVowel(c2)) {
            right--
        } else if(!isVowel(c1) && isVowel(c2)) {
            left++
        } else if(!isVowel(c1) && !isVowel(c2)) {
            left++
            right--
        }
    }
    var result = result_.join("")
    return result
};
/**
 * @param {character} c
 * @return {boolean}  
 */
var isVowel = function(c) {
    var s = "aeiouAEIOU";
    if(s.indexOf(c) != -1)
        return true
    return false
}

//test
var result = reverseVowels("hello")
console.log(result)
console.log(reverseVowels("leetcode"))