
public class Solution0647 {
	public int countSubstrings(String s) {
		int count = 0, left = 0, right = 0;
		for (int i = 0; i < s.length(); i++) {
			//第i个字符本身是回文
			count++;
			left = i - 1;
			right = i + 1;
			// 遍历每一个位置，向两侧扩展
			// 如果是奇数回文串，直接向两侧扩展
			// 如果是偶数回文串，cal(left, i, s)只向左扩展，避免重复
			// 如(a,a,a)=> ((a,a),a) (a,(a,a))
			// 第一个 ((a,a),a)是i=1位置的a向左扩展
			// 第二个 (a,(a,a))是i=2位置的a向左扩展
			count = count + cal(left, right, s) + cal(left, i, s);
		}
		return count;
	}

	public int cal(int left, int right, String s) {
		int count = 0;
		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) == s.charAt(right)) {
				count++;

				left--;
				right++;
			} else {
				break;
			}
		}

		return count;
	}

}
