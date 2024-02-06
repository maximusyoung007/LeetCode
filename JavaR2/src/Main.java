/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/2/6      create
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Java Round 2");

		//g = [1,2,3], s = [1,1]
//		int[] g = new int[] {1,2,3};
//		int[] s = new int[] {1,1};
		int[] g = new int[] {1,2};
		int[] s = new int[] {1,2,3};
		Solution0455 solution0455 = new Solution0455();
		System.out.println(solution0455.findContentChildren(g, s));
	}
}
