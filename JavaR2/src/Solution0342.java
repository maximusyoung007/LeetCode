/**
 *  n是2的次方，则 n为 ...0001000...,n-1为 ...0000111...，则n & (n-1) = 0
 *  n是4的次方，其二进制偶数位一定为1，如16=（10000），那么取奇数位都为1，偶数为都为0的数，进行与操作，结果应为0
 *  10000
 *  01010
 */
public class Solution0342 {
	public boolean isPowerOfFour(int n) {
		return n > 0 && (n & (n - 1)) == 0 && (n & (0xaaaaaaaa)) == 0;
	}
}
