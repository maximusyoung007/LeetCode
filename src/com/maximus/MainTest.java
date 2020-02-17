package com.maximus;

import com.maximus.easy.ReverseInteger;
import com.maximus.easy.TwoSum;
import com.maximus.medium.*;
import com.maximus.structure.ListNode;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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
        //比较两个字符是否相等
        /*char a = 'a',b = 'a';
        System.out.println(a == b);*/
        //字符串
        /*String s1 = "aa";
        String s2 = "bbb";
        s2 = s1;
        System.out.println(s2);*/

        //0005
        /*LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s1 = "babad";
        System.out.println(longestPalindrome.longestPalindrome(s1));
        String s2 = "cbbd";
        System.out.println(longestPalindrome.longestPalindrome(s2));*/

        //0006
    	/*ZigZagConversion z = new ZigZagConversion();
    	String s = "LEETCODEISHIRING";
    	String r = z.convert(s, 3);
    	System.out.println(r.equals("LCIRETOESIIGEDHN"));*/

    	//0007
		/*ReverseInteger reverseInteger = new ReverseInteger();
		int a = 123;
		System.out.println(reverseInteger.reverse(a));
		int b = -123;
		System.out.println(reverseInteger.reverse(b));
    	int c = 120;
    	System.out.println(reverseInteger.reverse(c));*/

		//0008
		StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();
		String s1 = "42";
		System.out.println(stringToIntegerAtoi.myAtoi(s1));
		String s2 = "   -42";
		System.out.println(stringToIntegerAtoi.myAtoi(s2));
		String s3 = "4193 with words";
		System.out.println(stringToIntegerAtoi.myAtoi(s3));
		String s4 = "words and 987";
		System.out.println(stringToIntegerAtoi.myAtoi(s4));
		String s5 = "-91283472332";
		System.out.println(stringToIntegerAtoi.myAtoi(s5));
		String s6 = "3.14159";
		System.out.println(stringToIntegerAtoi.myAtoi(s6));
		String s7 = "+1";
		System.out.println(stringToIntegerAtoi.myAtoi(s7));
		String s8 = "+-2";
		System.out.println(stringToIntegerAtoi.myAtoi(s8));
		String s9 = "   +0 123";
		System.out.println(stringToIntegerAtoi.myAtoi(s9));
		String s10 = "  0000000000012345678";
		System.out.println(stringToIntegerAtoi.myAtoi(s10));
		String s11 = "-000000000000001";
		System.out.println(stringToIntegerAtoi.myAtoi(s11));
		String s12 = "     +004500";
		System.out.println(stringToIntegerAtoi.myAtoi(s12));
		String s13 = "-2147483647";
		System.out.println(stringToIntegerAtoi.myAtoi(s13));
		String s14 = "-2147483649";
		System.out.println(stringToIntegerAtoi.myAtoi(s14));
		String s15 = "-   234";
		System.out.println(stringToIntegerAtoi.myAtoi(s15));
		String s16 = "0-1";
		System.out.println(stringToIntegerAtoi.myAtoi(s16));
		String s17 = "123-";
		System.out.println(stringToIntegerAtoi.myAtoi(s17));
		String s18 = "    -88827   5655  U";
		System.out.println(stringToIntegerAtoi.myAtoi(s18));
		//test char
		/*char a = ' ';
		System.out.println(a == ' ');*/

		//test max and min
		//System.out.println(Integer.MAX_VALUE + "\n" + Integer.MIN_VALUE);
    }
}
