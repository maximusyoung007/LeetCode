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
//		int[] g = new int[] {1,2};
//		int[] s = new int[] {1,2,3};
//		Solution0455 solution0455 = new Solution0455();
//		System.out.println(solution0455.findContentChildren(g, s));

//		Solution0605 solution0605 = new Solution0605();
//		int[] arr = new int[] {1, 0, 0, 0, 1};
//		int[] arr = new int[] {0};
//		System.out.println(solution0605.canPlaceFlowers(arr, 2));

//		int[][] points = new int[][] {{10, 16}, {2,8}, {1,6}, {7,12}};
//		int[][] points = new int[][] {{1, 2}, {3,4}, {5,6}, {7,8}};
//		int[][] points = new int[][] {{1, 2}, {2,3}, {3,4}, {4,5}};
//		int[][] points = new int[][] {{2, 3}, {2,3}};
//		int[][] points = new int[][] {{1, 2}, {3,4}};
//		int[][] points = new int[][] {{-2147483646,-2147483645}, {2147483646,2147483647}};
//		Solution0452 solution0452 = new Solution0452();
//		System.out.println(solution0452.findMinArrowShots(points));
		int[][] people = new int[][] {
			{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
		};
		Solution0406 solution0406 = new Solution0406();
		solution0406.reconstructQueue(people);
		System.out.println(solution0406.reconstructQueue(people));
	}
}
