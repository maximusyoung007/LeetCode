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
//		int[][] people = new int[][] {
//			{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
//		};
//		Solution0406 solution0406 = new Solution0406();
//		solution0406.reconstructQueue(people);n
//		int[][] res = solution0406.reconstructQueue(people);
//		System.out.println(solution0406.reconstructQueue(people));
//		int[] nums = new int[] {4,2,3};
//		int[] nums = new int[] {4,2,1};
//		int[] nums = new int[] {3,4,2,3};
//		Solution0665 solution0665 = new Solution0665();
//		System.out.println(solution0665.checkPossibility(nums));
//		int[] numbers = new int[] {2, 7, 11, 15};
//		int[] numbers = new int[] {1, 3, 4};
//		int[] numbers = new int[] {-1, 0};
//		Solution0169 solution0169 = new Solution0169();
//		int[] res = solution0169.twoSum(numbers, -1);
//		for (int r : res) {
//			System.out.println(r);
//		}
//		int[] nums1 = new int[] {1,2,3,0,0,0}, nums2 = new int[] {2,5,6};
//		int m = 3, n = 3;
		//nums1 = [1], m = 1, nums2 = [], n = 0
//		int[] nums1 = new int[] {0}, nums2 = new int[] {1};
//		int m = 0, n = 1;
//		Solution0088 solution0088 = new Solution0088();
//		solution0088.merge(nums1, m, nums2, n);

		Solution0076 solution0076 = new Solution0076();
//		String s = "ADOBECODEBANC", t = "ABC";
//		String s = "a", t = "a";
//		String s = "a", t = "aa";
		String s = "aaabc", t = "abc";
		System.out.println(solution0076.minWindow(s, t));
		System.out.println("end");
	}
}
