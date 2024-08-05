import java.util.Arrays;
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

		int[] nums = new int[] {100, 4, 200, 1, 3, 2};
//		int[] nums = new int[] {0,3,7,2,5,8,4,6,0,1};
		Solution0128 solution0128 = new Solution0128();
		System.out.println(solution0128.longestConsecutive(nums));

//		Solution0239 solution0239 = new Solution0239();
//		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
//		int[] res = solution0239.maxSlidingWindow(nums, 3);
//		for (int re : res) {
//			System.out.print(re + " ");
//		}
//		Solution0739 solution0739 = new Solution0739();
//		int[] temperatures = new int[] {73,74,75,71,69,72,76,73};
//		int[] temperatures = new int[] {89,62,70,58,47,47,46,76,100,70};

//		int[] res = solution0739.dailyTemperatures(temperatures);
//		for (int re : res) {
//			System.out.print( re);
//		}

//		Solution0020 solution0020 = new Solution0020();
//		System.out.println(solution0020.isValid("()[]{}"));
//		Solution0155 solution0155 = new Solution0155();
//		solution0155.testMinStack();
//		Solution0232 solution0232 = new Solution0232();
//		solution0232.testQueue();
//		Solution0769 solution0769 = new Solution0769();
//		System.out.println(solution0769.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
//		System.out.println(solution0769.maxChunksToSorted(new int[]{1, 2, 0, 3, 4}));
//		Solution0048 solution0048 = new Solution0048();
//		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
//		solution0048.rotate(matrix);
//		for (int[] ints : matrix) {
//			for (int anInt : ints) {
//				System.out.print(anInt);
//			}
//			System.out.println();
//		}
//		Solution0260 solution0260 = new Solution0260();
//		Solution0448 solution0448 = new Solution0448();
//		int[] nums = new int[] {4,3,2,7,8,2,3,1};
//		int[] nums = new int[] {1,1,1};
//		List<Integer> res = solution0448.findDisappearedNumbers(nums);
//		for (Integer i : res) {
//			System.out.println(i);
//		}
//		int[] nums = new int[] {-1,0};
//		int[] nums = new int[] {1,0};
//		int[] res = solution0260.singleNumber(nums);
//		for (int r : res) {
//			System.out.println(r);
//		}

//		Solution0693 solution0693 = new Solution0693();

//		Solution0476 solution0476 = new Solution0476();
//		System.out.println(solution0476.findComplement(5));
//		System.out.println(solution0476.findComplement(1));
//		System.out.println(solution0693.hasAlternatingBits(5));
//		System.out.println(solution0693.hasAlternatingBits(7));
//		System.out.println(solution0693.hasAlternatingBits(11));
//
//		Solution0268 solution0268 = new Solution0268();
//		System.out.println(solution0268.missingNumber(new int[]{3, 0, 1}));
//		System.out.println(solution0268.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
//		Solution0338 solution0338 = new Solution0338();
//		int[] res = solution0338.countBits(5);
//		for (int i : res) {
//			System.out.println(i);
//		}
//		Solution0318 solution0318 = new Solution0318();
//		String[] words = new String[] {"abcw","baz","foo","bar","xtfn","abcdef"};
//		String[] words = new String[] {"a","ab","abc","d","cd","bcd","abcd"};
//		String[] words = new String[] {"a","aa","aaa","aaaa"};
//		String[] words = new String[] {"a","ab","abc","d","cd","bcd","abcd"};
//		System.out.println(solution0318.maxProduct(words));
//		Solution0136 solution0136 = new Solution0136();
//		int[] nums = new int[] {2,2,1};
//		int[] nums = new int[] {4,1,2,2,1};
//		System.out.println(solution0136.singleNumber(nums));
//		Solution0461 solution0461 = new Solution0461();
//		System.out.println(solution0461.hammingDistance(1, 4));
//		System.out.println(solution0461.hammingDistance(1, 3));
//		Solution0202 solution0202 = new Solution0202();
//		System.out.println(solution0202.isHappy(19));
////		System.out.println(solution0202.isHappy(3)3);
//		Solution0238 solution0238 = new Solution0238();
//		int[] res = solution0238.productExceptSelf(new int[] {1,2,3,4});
//		int[] res = solution0238.productExceptSelf(new int[] {-1,1,0,-3,3});
//		System.out.println(Arrays.toString(res));

//		Solution0067 solution0067 = new Solution0067();
//		System.out.println(solution0067.addBinary("11", "1"));
//		System.out.println(solution0067.addBinary("1010", "1011"));
//		System.out.println(solution0067.addBinary("1111", "1111"));

//		int a = 1;
//		tes(a);
//		System.out.println(a);
//
//		int[] nums = new int[] {1,1,1,1,1};
//		int target = 3;
//		Solution0494 solution0494 = new Solution0494();
//		System.out.println(solution0494.findTargetSumWays(nums, target));

//		Solution0047 solution0047 = new Solution0047();
//		List<List<Integer>> res = solution0047.permuteUnique(new int[] {1,1,1});
//		List<List<Integer>> res = solution0047.permuteUnique(new int[] {1,2,3});
//		List<List<Integer>> res = solution0047.permuteUnique(new int[] {1,1,2});
//		for (List<Integer> pr : res) {
//			for (Integer in : pr) {
//				System.out.print(in);
//			}
//			System.out.println();
//		}
//		System.out.println("exit");
//		Solution0040 solution0040 = new Solution0040();
//		int[] candidates = new int[]{10,1,2,7,6,1,5};
//		int[] candidates = new int[]{2,5,2,1,2};
//		int[] candidates = new int[] {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,
//			20,21,29,24,17
//			,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
//		int target = 27;
//		int target = 8;
//		List<List<Integer>> res = solution0040.combinationSum2(candidates, target);
//		for (List<Integer> pr : res) {
//			for (Integer in : pr) {
//				System.out.print(in + " ");
//			}
//			System.out.println();

//		Solution0310 solution0310 = new Solution0310();
//		int[][] edges = new int[][] {
//			{3,0},{3,1},{3,2},{3,4},{5,4}
//		};
//		int[][] edges = new int[][] {
//			{1,0}, {1,2}, {1,3}
//		};
//		int[][] edges = new int[][] {
//
//		};
//		int[][] edges = new int[][] {
//			{1,0}
//		};
//		System.out.println(solution0310.findMinHeightTrees(6, edges));
//		System.out.println(solution0310.findMinHeightTrees(4, edges));
//		System.out.println(solution0310.findMinHeightTrees(2, edges));
	}

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
//		System.out.println("exit");

//}
