/**
 * x ^ x = 0, x ^ 0 = 0
 * 设最后两个不同的值是x1,x2
 * 第一次遍历， 依次异或，最后x3 = x1^x2, x3必然有一位为1，x1,x2这一位一个为1，一个为0
 * 第二次遍历，按照这一位为1，分组异或
 *
 *      s = 101100
 *     ~s = 010011
 * (~s)+1 = 010100 // 根据补码的定义，这就是 -s   效果：s 的最低 1 左侧取反，右侧不变
 * s & -s = 000100 // lowbit
 */
public class Solution0260 {
	public int[] singleNumber(int[] nums) {
		int x1 = 0, x2 = 0;

		int s = 0;
		for (int i = 0; i < nums.length; i++) {
			s = s ^ nums[i];
		}

		int lowBits = s & -s;

		for (int num : nums) {
			if ((num & lowBits) == 0) {
				x1 ^= num;
			}
		}
		x2 = s ^ x1;

		return new int[] {x1, x2};
	}
}
