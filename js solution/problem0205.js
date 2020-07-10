/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function (s, t) {
    return a(s,t) && a(t,s);
};
var a = function (s, t) {
    let myMap = new Map();
    for(var i = 0;i < s.length;i++) {
        var s_ = s.charAt(i);
        var t_ = t.charAt(i);
        if(myMap.get(s_) != null) {
            //s对应的不是t,不同构了
            if(myMap.get(s_) != t_)
                return false;
        }
        else {
            myMap.set(s_,t_);
        }
    }
    return true;
}

console.log(isIsomorphic("egg","add"));
console.log(isIsomorphic("foo", "bar"));
console.log(isIsomorphic("paper", "title"));
