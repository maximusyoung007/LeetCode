/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    var temp = 0,time = 0
    for(var i = 0;i < nums.length;i++) {
        if(nums[i] != 0) {
            temp = nums[i]
            nums[i] = nums[time]
            nums[time] = temp
            time++
        }
    }
}

//test
var nums = [0,1,0,3,12]
moveZeroes(nums)
