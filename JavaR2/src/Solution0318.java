/**
 * 将字母转化为二进制数，对于一个word的每一位char，将 char - 'a'，可以得到一个数字映射，如a = 0, b=1, ... ,z=25
 * 将char左移，即可得到在对应位置是否为1，如b左移后变为 10，表示在b的位置上有值，则表示原字母里有b
 * 将得到的结果做或操作，如 c得到 100， b得到 10， c|b = 110, 表示原字母包含c和b
 */
public class Solution0318 {
	public int maxProduct(String[] words) {
		int n = words.length;
		int[] mask = new int[n];
		for (int i = 0; i < n; i++) {
			for (char c : words[i].toCharArray()) {
				mask[i] |= 1 << (c - 'a');
			}
		}

		int res = 0;
		int len;
		for (int i = 0; i < n; i++) {
			int len1 = 0, len2;
			for (int j = i + 1; j < n; j++) {
				//如果两个单词有相同字母，那么一定有相同的数字，那么与操作的结果一定为1
				len2 = words[j].length();
				if ((mask[i] & mask[j]) == 0 && len2 > len1) {
					len = words[i].length() * len2;
					len1 = len2;
					if (len > res) {
						res = len;
					}
				}
			}
		}

		return res;
	}
}
