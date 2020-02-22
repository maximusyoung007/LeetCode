package com.maximus;

import com.maximus.easy.*;
import com.maximus.medium.*;
import com.maximus.structure.ListNode;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

//测试数据
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
		/*StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();
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
		System.out.println(stringToIntegerAtoi.myAtoi(s18));*/
		//test char
		/*char a = ' ';
		System.out.println(a == ' ');*/

		//test max and min
		//System.out.println(Integer.MAX_VALUE + "\n" + Integer.MIN_VALUE);

		//0009
		/*PalindromeNumber palindromeNumber = new PalindromeNumber();
		System.out.println(palindromeNumber.isPalindrome(121));
		System.out.println(palindromeNumber.isPalindrome(-121));
		System.out.println(palindromeNumber.isPalindrome(10));*/

		//0011
		/*ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
		int[] a = {1,8,6,2,5,4,8,3,7};
		System.out.println(containerWithMostWater.maxArea(a));*/

		//0012
		/*IntegerToRoman integerToRoman = new IntegerToRoman();
		System.out.println(integerToRoman.intToRoman(3));
		System.out.println(integerToRoman.intToRoman(4));
		System.out.println(integerToRoman.intToRoman(9));
		System.out.println(integerToRoman.intToRoman(58));
		System.out.println(integerToRoman.intToRoman(1994));
		System.out.println(integerToRoman.intToRoman(1800));*/

		//0013
		/*RomanToInteger romanToInteger = new RomanToInteger();
		System.out.println(romanToInteger.romanToInt("III"));
		System.out.println(romanToInteger.romanToInt("IX"));
		System.out.println(romanToInteger.romanToInt("LVIII"));
		System.out.println(romanToInteger.romanToInt("MCMXCIV"));
		System.out.println(romanToInteger.romanToInt("MDCCC"));*/

		//0014
		//LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		//String[] strs1 = {"flower","flow","flight"};
		//System.out.println(longestCommonPrefix.longestCommonPrefix(strs1));
		//String[] strs2 = {"dog","racecar","car"};
		//System.out.println(longestCommonPrefix.longestCommonPrefix(strs2));
		//String[] strs3 = {"aca","cba"};
		//System.out.println(longestCommonPrefix.longestCommonPrefix(strs3));

		//0015
		/*ThreeSum threeSum = new ThreeSum();
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum.threeSum(nums).toString());*/

		//0016
		/*ThreeSumClosest threeSumClosest = new ThreeSumClosest();
		int[] nums = {-1,2,1,-4};
		System.out.println(threeSumClosest.threeSumClosed(nums,1));
		int[] nums1 = {0,2,1,-3};
		System.out.println(threeSumClosest.threeSumClosed(nums1,1));
		int[] nums2 = {0,1,2};
		System.out.println(threeSumClosest.threeSumClosed(nums2,3));*/

		//0017
		/*LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
		System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));
		System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations(""));*/

		//0018
		//FourSum fourSum = new FourSum();
		/*int[] nums0 = {1,0,-1,0,-2,2};
		int target = 0;
		System.out.println(fourSum.fourSum(nums0,target));
		int[] nums1 = {-3,-2,-1,0,0,1,2,3};
		System.out.println(fourSum.fourSum(nums1,target));
		int[] nums2 = {1,-2,-5,-4,-3,3,3,5};
		System.out.println(fourSum.fourSum(nums2,-11));
		int[] nums3 = {0,1,5,0,1,5,5,-4};
		System.out.println(fourSum.fourSum(nums3,11));*/

		//0019
		/*RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode result = removeNthNodeFromEndOfList.removeNthFormEnd(l1,2);
		ListNode p = result;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}*/

		//0020
		/*ValidParentheses validParentheses = new ValidParentheses();
		System.out.println(validParentheses.isValid("()"));
		System.out.println(validParentheses.isValid("()[]{}"));
		System.out.println(validParentheses.isValid("(]"));
		System.out.println(validParentheses.isValid("([)]"));
		System.out.println(validParentheses.isValid("{[]}"));*/

		//0021
		MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		ListNode result = mergeTwoSortedLists.mergeTwoLists(l1,n1);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
