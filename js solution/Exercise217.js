/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containDuplicate = function(nums) {
    var exist = new Set()
    for(var i = 0;i < nums.length;i++) 
        exist.add(nums[i])
    return exist.size != nums.length
}

//test
var nums = [1,2,3,1]
console.log(containDuplicate(nums))
var nums2 = [1,2,3,4]
console.log(containDuplicate(nums2))
var nums3 = [1,1,1,3,3,4,3,2,4,2]
console.log(containDuplicate(nums3))