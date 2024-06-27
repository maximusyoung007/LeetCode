/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/6/26      create
 */
public class Solution0190 {
	public int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			//左移一位，这样上一个循环加的数就向左移动了，n的低位变成了res的高位，然后又给最后一位加上0
			res <<= 1;
			//n与1,如果最后一个是1，则结果为1；否则结果为0，把结果加到res的最后一位
			res += n & 1;
			//n右移1位，去掉最低位
			n >>= 1;
		}

		return res;
	}
}
