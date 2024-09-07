/**
 * @author maximusyoung
 * babaabaa
 * dp[i,j]表示以i为左边界、j为右边界的字串是否是回文串
 * dp[i,i]=true
 * s[i]==s[i+1],  dp[i,i+1]=true
 * if dp[i+1,j-1] = true, s[i]==s[j], 则dp[i,j]=true
 */
public class Solution0005 {

	boolean[][] dp;
	int start = 0, end = 0;
	int res = 0;
	public String longestPalindrome(String s) {
		int len = s.length();
		dp = new boolean[len][len];

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
			expand(i-1, i+1, dp, s);
			if (i + 1 < len && s.charAt(i) == s.charAt(i+1)) {
				dp[i][i+1] = true;
				expand(i-1, i+2, dp, s);
			}
		}

		return s.substring(start, end+1);
	}

	public void expand(int i, int j, boolean[][] dp, String s) {

		while (i >= 0 && j < s.length()) {
			if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
				dp[i][j] = true;
				i--;
				j++;
			} else {
				break;
			}
		}
		j--;
		i++;
		if (j - i + 1 >= res) {
			res = j - i + 1;
			start = i;
			end = j;
		}
	}
}