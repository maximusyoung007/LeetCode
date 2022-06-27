public class Solution0522 {
	public int findLUSlength(String[] strs) {
		int ans = -1;
		for (int i = 0; i < strs.length; i++) {
			boolean ok = true;
			for (int j = 0; j < strs.length; j++) {
				if (i == j) continue;
				if (isSub(strs[i], strs[j])) ok = false;
			}
			if (ok){
				if (strs[i].length() > ans) {
					ans = strs[i].length();
				}
			}
		}
		return ans;
	}

	public boolean isSub(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		if (m > n) {
			return false;
		}
		s1 = " " + s1;
		s2 = " " + s2;

		int[][] f = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			f[i][0] = 1;
		}

		for (int j = 0; j <= n; j++) {
			f[0][j] = 1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					f[i][j] = f[i-1][j-1] + 1;
				} else {
					f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
				}
			}
		}
		int len = f[m][n] - 1;
		if (len == m) {
			return true;
		} else {
			return false;
		}
	}
}
