import java.util.Arrays;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/6      create
 */
public class Solution0455 {
	public int findContentChildren(int[] g, int[] s) {
		//对孩子和饼干排序，优先把小饼干分给胃口小的小朋友
		Arrays.sort(g);
		Arrays.sort(s);
		int children = 0, cookie = 0;
		while (children < g.length && cookie < s.length) {
			if (s[cookie] >= g[children]) {
				children++;
			}
			cookie++;
		}
		return children;
	}

}
