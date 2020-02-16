package com.maximus;

import com.maximus.easy.TwoSum;
import com.maximus.medium.AddTwoNumbers;
import com.maximus.medium.LengthOfLongestSubstring;
import com.maximus.structure.ListNode;

public class MainTest {
    public static void main(String[] args){
        //0001
        /*TwoSum twoSum0001 = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result0001 = new int[2];
        result0001 = twoSum0001.twoSum(nums,target);
        for(int i = 0;i < result0001.length;i++){
            System.out.println(result0001[i]);
        }*/
        //0002
        /*AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l1.next = l12;
        ListNode l13 = new ListNode(3);
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        l2.next = l21;
        ListNode l22 = new ListNode(4);
        l21.next = l22;
        ListNode result = addTwoNumbers.addTwoNumbers(l1,l2);
        for(ListNode x = result;x != null;x = x.next) {
            System.out.println(x.val);
        }*/
        //0003
        /*LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String s1 = "abcabcbb";
        int r1 = lengthOfLongestSubstring.lengthOfLongestSubstring(s1);
        String s2 = "bbbbb";
        int r2 = lengthOfLongestSubstring.lengthOfLongestSubstring(s2);
        String s3 = "pwwkew";
        int r3 = lengthOfLongestSubstring.lengthOfLongestSubstring(s3);
        System.out.println(r1 + "\n" + r2 + "\n" + r3);*/
        
    }
}
