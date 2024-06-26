public class Solution0461 {
	public int hammingDistance(int x, int y) {
		//异或，相同的是1，不同的是0
		int z = x ^ y;
		int result = 0;
		while (z > 0) {
			//和1与，即 00000..001，最后一位是1，则结果为1，否则为0
			result += z & 1;
			//右移一位
			z >>= 1;
		}

		return result;
	}
}
