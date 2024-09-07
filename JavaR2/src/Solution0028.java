public class Solution0028 {
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}

		int[] next = getNext(needle);

		int j = 0;
		for (int i = 0; i < haystack.length(); i++) {
			while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
				j = next[j-1];
			}
			if (haystack.charAt(i) == needle.charAt(j)) {
				j++;
			}
			if (j == needle.length()) {
				return i - needle.length() + 1;
			}
		}

		return -1;
	}

	//计算前缀表
	public static int[] getNext(String t) {
		int len = t.length();
		int[] next = new int[len];
		int j = 0;

		//i指向后缀末尾， j指向前缀末尾
		for (int i = 1; i < t.length(); i++) {
			while (j > 0 && t.charAt(i) != t.charAt(j)) {
				j = next[j-1];
			}
			if (t.charAt(i) == t.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}
