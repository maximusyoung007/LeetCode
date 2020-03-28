/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
    if(num == 1)
        return true
    for(var i = 2;i <= num / 2;i++) {
        if(i * i == num) 
            return true
    }
    return false;
};

//test
for(var i = 1;i <= 20;i++) {
    console.log(isPerfectSquare(i))
}