import java.util.List;

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

//		Solution0076 solution0076 = new Solution0076();
//		String s = "ADOBECODEBANC", t = "ABC";
//		String s = "a", t = "a";
//		String s = "a", t = "aa";
//		String s = "aaabc", t = "abc";
//		System.out.println(solution0076.minWindow(s, t));
//		System.out.println("end");

//		Solution0033 solution0033 = new Solution0033();
//		int[] nums = new int[] {4,5,6,7,0,1,2};
//		System.out.println(solution0033.search(nums, 4));
//		System.out.println(solution0033.search(nums, 5));
//		System.out.println(solution0033.search(nums, 6));
//		System.out.println(solution0033.search(nums, 7));
//		System.out.println(solution0033.search(nums, 0));
//		System.out.println(solution0033.search(nums, 1));
//		System.out.println(solution0033.search(nums, 2));
//		System.out.println(solution0033.search(nums, 9));
//		System.out.println(solution0033.search(nums, 3));

//		int[] nums = new int[] {1, 3};
//		System.out.println(solution0033.search(nums, 1));
//		System.out.println(solution0033.search(nums, 0));

//		int[] nums = new int[] {1};
//		System.out.println(solution0033.search(nums, 0));
//		System.out.println(solution0033.search(nums, 1));

//		int[] nums = new int[] {3, 1};
//		System.out.println(solution0033.search(nums, 1));

//		Solution0153 solution0153 = new Solution0153();
//		int[] nums = new int[] {4,5,6,7,0,1,2};
//		int[] nums = new int[] {3,4,5,1,2};
//		int[] nums = new int[] {11,13,15,17};
//		System.out.println(solution0153.findMin(nums));

//		Solution0154 solution0154 = new Solution0154();
//		System.out.println(solution0154.findMin(new int[]{2, 2, 2, 0, 1}));
//		System.out.println(solution0154.findMin(new int[]{2, 0, 1, 2, 2, 2}));
//		System.out.println(solution0154.findMin(new int[]{2, 1, 2, 2, 2}));
//		System.out.println(solution0154.findMin(new int[]{2, 0, 0, 1, 2}));

//		Solution0540 solution0540 = new Solution0540();
//		System.out.println(solution0540.singleNonDuplicate(new int[]{1, 2, 2, 3, 3}));
//		System.out.println(solution0540.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));

//		Solution0695 solution0695 = new Solution0695();
//		int[][] grid = new int[][] {
//			{0,0,1,0,0,0,0,1,0,0,0,0,0},
//			{0,0,0,0,0,0,0,1,1,1,0,0,0},
//			{0,1,1,0,1,0,0,0,0,0,0,0,0},
//			{0,1,0,0,1,1,0,0,1,0,1,0,0},
//			{0,1,0,0,1,1,0,0,1,1,1,0,0},
//			{0,0,0,0,0,0,0,0,0,0,1,0,0},
//			{0,0,0,0,0,0,0,1,1,1,0,0,0},
//			{0,0,0,0,0,0,0,1,1,0,0,0,0}};
//		int[][] grid = new int[][] {{0,0,0,0,0,0,0,0}};
//		int[][] grid = new int[][] {{1}};
//		int[][] grid = new int[][] {{1,1,1,1,1,1,1,1}};
//		System.out.println(solution0695.maxAreaOfIsland(grid));

		//[[1,1,0],[1,1,0],[0,0,1]]
//		Solution0547 solution0547 = new Solution0547();
//		int[][] isConnected = new int[][] {
//			{1,1,0},{1,1,0},{0,0,1}
//		};
//		int[][] isConnected = new int[][] {{1,0,0},{0,1,0},{0,0,1}};
//		System.out.println(solution0547.findCircleNum(isConnected));

//		Solution0417 solution0417 = new Solution0417();
//		int[][] heights = new int[][] {
//			{1,2,2,3,5},
//			{3,2,3,4,4},
//			{2,4,5,3,1},
//			{6,7,1,4,5},
//			{5,1,1,2,4}
//		};
		//[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//		System.out.println(solution0417.pacificAtlantic(heights));
//		int [][] heights = new int[][] {
//			{2,1},
//			{1,2}
//		};
//		int[][] heights = new int[][] {
//			{3,3,3},
//			{3,1,3},
//			{0,2,4}
//		};
//		int[][] heights = new int[][] {
//			{9,10,14,9,2,6,16},
//			{0,0,4,5,16,16,15},
//			{10,8,16,10,12,8,11},
//			{3,13,15,0,19,16,5},
//			{13,17,1,12,11,8,14}, //4
//			{14,9,11,10,5,19,11},
//			{15,3,14,3,9,11,5},
//			{9,17,5,15,5,15,7},
//			{12,11,10,0,9,14,19},
//			{9,1,4,5,8,18,18},
//			{1,4,17,16,5,12,18},
//			{18,2,0,0,2,11,5},
//			{1,15,8,18,13,15,13},
//			{11,14,4,13,3,1,1},
//			{4,2,11,19,17,8,11},
//			{4,11,10,0,1,18,11},
//			{11,7,14,4,7,8,9},
//			{12,0,0,3,6,2,12},
//			{0,16,3,3,5,6,6},
//			{6,11,17,12,18,5,15},
//			{16,14,8,4,10,16,6},
//			{9,7,2,13,5,5,5}, // 21, 6
//			{14,17,19,4,7,2,5},
//			{11,16,18,14,8,10,12}, //23
//			{5, 11,10,17,2,2,13},
//			{7, 6, 12,3,5,3,12},
//			{12,10,0,19,3,15,12},
//			{13,2,12,1,1,15,19},
//			{11,15,10,8,14,19,8},
//			{16,2,2,16,5,15,16},
//			{9,8,2,17,15,14,16},
//			{17,2,17,17,0,6,3},
//			{3,4,13,9,1,4,0},
//			{1,3,13,10,14,9,4}
//		};
		//18 14 8 7 5 5 5
//		System.out.println(heights[23][2]);
//		System.out.println(solution0417.pacificAtlantic(heights));

//		Solution0451 solution0451 = new Solution0451();
//		System.out.println(solution0451.frequencySort("tree"));
//		System.out.println(solution0451.frequencySort("cccaaa"));
//		System.out.println(solution0451.frequencySort("Aabb"));
//		System.out.println(solution0451.frequencySort("a"));

//		Solution0046 solution0046 = new Solution0046();
//		List<List<Integer>> res = solution0046.permute(new int[] {1,1,1});
//		List<List<Integer>> res = solution0046.permute(new int[] {1});
//		for (List<Integer> pr : res) {
//			for (Integer in : pr) {
//				System.out.print(in);
//			}
//			System.out.println();
		}

//		Solution0077 solution0077 = new Solution0077();
//		List<List<Integer>> res = solution0077.combine(4, 2);
//		List<List<Integer>> res = solution0077.combine(1, 1);
//		for (List<Integer> pr : res) {
//			for (Integer in : pr) {
//				System.out.print(in);
//			}
//			System.out.println();
//		}

//		Solution0079 solution0079 = new Solution0079();
//		char[][] board = new char[][] {
//			{'A','B','C','E'},
//			{'S','F','C','S'},
//			{'A','D','E','E'}
//		};
		//["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]
//		System.out.println(solution0079.exist(board, "ABCCED"));
//		System.out.println(solution0079.exist(board, "SEE"));
//		char[][] board = new char[][] {
//			{'A', 'B'},
//			{'C', 'D'}
//		};
//
//		char[][] board = new char[][] {
//			{'A','B','C','E'},
//			{'S','F','E','S'},
//			{'A','D','E','E'}
//		};
//		System.out.println(solution0079.exist(board, "ABCB"));
//		System.out.println(solution0079.exist(board, "ABCESEEEFS"));

//		int[][] grid = new int[][] {
//			{0,1,0},
//			{0,0,0},
//			{0,0,1}
//		};

//		int[][] grid = new int[][] {
//			{1,1,1,1,1},
//			{1,0,0,0,1},
//			{1,0,1,0,1},
//			{1,0,0,0,1},
//			{1,1,1,1,1}
//		};
//		Solution0934 solution0934 = new Solution0934();
//		System.out.println(solution0934.shortestBridge(grid));

//		Solution0130 solution0130 = new Solution0130();
//		char[][] board = new char[][] {
//			{'X','X','X','X'},
//			{'X','O','O','X'},
//			{'X','X','O','X'},
//			{'X','O','X','X'}
//		};
//		solution0130.solve(board);

//		Solution0257 solution0257 = new Solution0257();
//		TreeNode node4 = new TreeNode(4, null, null);
//		TreeNode node3 = new TreeNode(3, null, null);
//		TreeNode node2 = new TreeNode(2, node4, null);
//		TreeNode node1 = new TreeNode(1, node2, node3);
//		List<String> res = solution0257.binaryTreePaths(node1);
//		for (String s : res) {
//			System.out.println(s);
//		}
		System.out.println("exit");
	}
}
