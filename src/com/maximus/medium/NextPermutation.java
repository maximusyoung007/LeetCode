package com.maximus.medium;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int pos = -1, pos2 = -1;
        for(int i = nums.length - 2;i >= 0;i--) {
            if(nums[i] >= nums[i+1])
                continue;
            else {
                pos = i;
                break;
            }
        }
        if(pos == -1) {
            reverse(nums,0,nums.length - 1);
        }
        else {
            for (int i = nums.length - 1; i > pos; i--) {
                if (nums[i] > nums[pos]) {
                    pos2 = i;
                    break;
                }
            }
            if(pos2 != -1) {
                int temp = nums[pos];
                nums[pos] = nums[pos2];
                nums[pos2] = temp;
            }
            reverse(nums, pos + 1, nums.length - 1);
        }
    }
    void reverse(int[] nums,int begin,int end) {
        int temp = 0;
        while(begin < end){
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
