/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function (nums, k) {
    let mySet = new Set();
    for(var i = 0;i < nums.length;i++) {
        if(mySet.has(nums[i])) return true;
        mySet.add(nums[i]);
        if(mySet.size > k) {
            mySet.delete(nums[i - k]);
        }
    }
    return false;
};

var nums = ["1","2","3","1"];
console.log(containsNearbyDuplicate(nums,3));
var nums = ["1","0","1","1"];
console.log(containsNearbyDuplicate(nums,1));
var nums = [1,2,3,1,2,3]
console.log(containsNearbyDuplicate(nums, 2));
