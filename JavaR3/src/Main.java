import com.sun.source.tree.Tree;
import solution.ListNode;
import solution.Solution0002;
import solution.Solution0017;
import solution.Solution0019;
import solution.Solution0020;
import solution.Solution0021;
import solution.Solution0022;
import solution.Solution0025;
import solution.Solution0039;
import solution.Solution0046;
import solution.Solution0052;
import solution.Solution0056;
import solution.Solution0057;
import solution.Solution0061;
import solution.Solution0071;
import solution.Solution0077;
import solution.Solution0079;
import solution.Solution0082;
import solution.Solution0086;
import solution.Solution0092;
import solution.Solution0098;
import solution.Solution0100;
import solution.Solution0101;
import solution.Solution0102;
import solution.Solution0103;
import solution.Solution0105;
import solution.Solution0106;
import solution.Solution0112;
import solution.Solution0114;
import solution.Solution0124;
import solution.Solution0127;
import solution.Solution0129;
import solution.Solution0130;
import solution.Solution0150;
import solution.Solution0155;
import solution.Solution0199;
import solution.Solution0200;
import solution.Solution0207;
import solution.Solution0210;
import solution.Solution0222;
import solution.Solution0224;
import solution.Solution0226;
import solution.Solution0230;
import solution.Solution0236;
import solution.Solution0399;
import solution.Solution0433;
import solution.Solution0452;
import solution.Solution0530;
import solution.Solution0637;
import solution.Solution0909;
import solution.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author maximusyoung
 */
public class Main {
	public static void main(String[] args) {
//		int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
//		int[][] intervals = new int[][] {{1,4},{4,5}};
//		Solution0056 solution0056 = new Solution0056();
//		int[][] res = solution0056.merge(intervals);
//		for (int[] re : res) {
//			System.out.print(re[0] + "-" + re[1]);
//			System.out.println();
//		}
//		String fileName = "33_Item_20241125.csv";
//		String[] res = fileName.split("\\.");

		//intervals = [[1,3],[6,9]], newInterval = [2,5]
		//intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//		int[][] intervals = new int[][] {{1,3}, {6,9}};
//		int[][] intervals = new int[][] {{1,3}, {4,9}};
//		int[] newInterval = new int[] {2,5};
//		int[][] intervals = new int[][] {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
//		int[] newInterval = new int[] {4,8};
//		int[][] intervals = new int[][] {{2,5},{6,7},{8,9}};
//		int[] newInterval = new int[] {0,1};
//		Solution0057 solution0057 = new Solution0057();
//		int[][] res = solution0057.insert(intervals, newInterval);
//		for (int[] re : res) {
//			System.out.print(re[0] + "-" + re[1]);
//			System.out.println();
//		}
//		Solution0020 solution0020 = new Solution0020();
//		System.out.println(solution0020.isValid("()[]{}"));
//		System.out.println(solution0020.isValid("(({}))"));
//		System.out.println(solution0020.isValid("(]"));
//		System.out.println(solution0020.isValid("]"));
//		System.out.println(solution0020.isValid(""));

//		Solution0452 solution0452 = new Solution0452();
		//[[1,2],[3,4],[5,6],[7,8]]
//		int[][] points = new int[][] {{10,16},{2,8},{1,6},{7,12}};
//		int[][] points = new int[][] {{1,2},{3,4},{5,6},{7,8}};
//		int[][] points = new int[][] {{1,2},{2,3},{3,4},{4,5}};
//		System.out.println(solution0452.findMinArrowShots(points));
//		Solution0071 solution0071 = new Solution0071();
//		System.out.println(solution0071.simplifyPath("/home/"));
//		System.out.println(solution0071.simplifyPath("/home//foo/"));
//		System.out.println(solution0071.simplifyPath("/home/user/Documents/../Pictures"));
//		System.out.println(solution0071.simplifyPath("/../"));
//		System.out.println(solution0071.simplifyPath("/a./"));
//		System.out.println(solution0071.simplifyPath("/./"));
//		System.out.println(solution0071.simplifyPath("/.../a/../b/c/../d/./"));
//		System.out.println(solution0071.simplifyPath("b/../../c/"));
//		System.out.println(solution0071.simplifyPath("/a//b////c/d//././/.."));
//		System.out.println(solution0071.simplifyPath("/."));
//		System.out.println(solution0071.simplifyPath("/.."));
//		System.out.println(solution0071.simplifyPath("/a/.."));
//		System.out.println(solution0071.simplifyPath("/..."));
//		System.out.println(solution0071.simplifyPath("/hello../world"));
//		System.out.println(solution0071.simplifyPath("/hello./world"));
//		System.out.println(solution0071.simplifyPath("/./qvzVS/oBx/vIN///../lyLw////"));
//		System.out.println(solution0071.simplifyPath("/a//b.."));
//		System.out.println(solution0071.simplifyPath("/a//b."));
//		Solution0155.MinStack minStack = new Solution0155.MinStack();
//		minStack.push(0);
//		minStack.push(1);
//		minStack.push(0);
//		System.out.println(minStack.getMin());
//		minStack.pop();
//		System.out.println(minStack.getMin());

//		Solution0150 solution0150 = new Solution0150();
//		System.out.println(solution0150.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
//		System.out.println(solution0150.evalRPN(new String[]{"4","13","5","/","+"}));
//		System.out.println(solution0150.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));

//		String s1 = "-11";
//		System.out.println(Integer.parseInt(s1));

//		Solution0100 solution0100 = new Solution0100();
//		Integer[] tree1 = new Integer[] {1,2,3};
//		Integer[] tree2 = new Integer[] {1,2,3};
//		Integer[] tree1 = new Integer[] {1,2};
//		Integer[] tree2 = new Integer[] {1, null, 2};
//		Integer[] tree1 = new Integer[] {1, 2, 1};
//		Integer[] tree2 = new Integer[] {1, 1, 2};
//
//		System.out.println(solution0100.isSameTree(generateTree(tree1), generateTree(tree2)));

//		Solution0226 solution0226 = new Solution0226();
//		Integer[] root = new Integer[] {2,1,3};
		//[4,2,7,1,3,6,9]
//		Integer[] root = new Integer[] {4,2,7,1,3,6,9};
//		Integer[] root = new Integer[] {};
//		Integer[] root = new Integer[] {1,2};
//		TreeNode res = solution0226.invertTree(generateTree(root));


//		Solution0224 solution0224 = new Solution0224();
//		System.out.println(solution0224.calculate("1+1"));
//		System.out.println(solution0224.calculate(" 2-1 + 2 "));
//		System.out.println(solution0224.calculate("(1+(4+5+2)-3)+(6+8)"));
//		System.out.println(solution0224.calculate("(-1+(-4+5+2)-3)+(6+8)"));
//		System.out.println(solution0224.calculate("2147483647"));
//		System.out.println(solution0224.calculate("1-(     -2)"));
//		Solution0002 solution0002 = new Solution0002();
//		ListNode node1 = new ListNode(2);
//		ListNode node2 = new ListNode(4);
//		ListNode node3 = new ListNode(3);
//		node1.next = node2;
//		node2.next = node3;
//		ListNode l1 = new ListNode(5);
//		ListNode l2 = new ListNode(6);
//		ListNode l3 = new ListNode(4);
//		l1.next = l2;
//		l2.next = l3;
//		int[] a = new int[] {2,4,3};
//		int[] b = new int[] {5,6,4};
//		int[] a = new int[] {9,9,9,9,9,9,9};
//		int[] b = new int[] {9,9,9,9};
//		ListNode res = solution0002.addTwoNumbers(generateListNode(a), generateListNode(b));
//		while (res != null) {
//			System.out.println(res.val);
//			res = res.next;
//		}
//
//		Solution0021 solution0021 = new Solution0021();
//		int[] l1 = new int[] {1,2,4};
//		int[] l2 = new int[] {1,3,4};
//		int[] l1 = new int[] {};
//		int[] l2 = new int[] {};
//		ListNode res = solution0021.mergeTwoLists(generateListNode(l1), generateListNode(l2));

//		Solution0101 solution0101 = new Solution0101();
		//root = [1,2,2,3,4,4,3]
		//[1,2,2,null,3,null,3]
//		Integer[] root = new Integer[] {1,2,2,3,4,4,3};
//		Integer[] root = new Integer[] {1,2,2,null,3,null,3};
//		Integer[] root = new Integer[] {1,0};

//		System.out.println(solution0101.isSymmetric(generateTree(root)));

		//[[7,null],[13,0],[11,4],[10,2],[1,0]]

		//head = [1,2,3,4,5], left = 2, right = 4
		//[1,4,3,2,5]
//		Solution0092 solution0092 = new Solution0092();
//		int[] head = new int[] {1,2,3,4,5};
//		int left = 2, right = 4;
//		int left = 1, right = 4;
//		printLinkList(solution0092.reverseBetween(generateListNode(head), left, right));
//		printLinkList(solution0092.reverseBetween(generateListNode(head), 1, 4));
//		printLinkList(solution0092.reverseBetween(generateListNode(head), 1, 5));
//		printLinkList(solution0092.reverseBetween(generateListNode(new int[]{5}), 1, 1));

//		Solution0019 solution0019 = new Solution0019();
//		printLinkList(solution0019.removeNthFromEnd(generateListNode(new int[] {1,2,3,4,5}), 2));
//		printLinkList(solution0019.removeNthFromEnd(generateListNode(new int[] {1,2,3,4,5}), 1));
//		printLinkList(solution0019.removeNthFromEnd(generateListNode(new int[] {1,2,3,4,5}), 5));
//		printLinkList(solution0019.removeNthFromEnd(generateListNode(new int[] {1,2,3,4,5}), 4));
//		printLinkList(solution0019.removeNthFromEnd(generateListNode(new int[] {1}), 1));
//		printLinkList(solution0019.removeNthFromEnd(generateListNode(new int[] {1,2}), 1));
//		printLinkList(solution0019.removeNthFromEnd(generateListNode(new int[] {1,2}), 1));

//		Solution0082 solution0082 = new Solution0082();
//		printLinkList(solution0082.deleteDuplicates(generateListNode(new int[] {1,2,3,3,4,5})));
//		printLinkList(solution0082.deleteDuplicates(generateListNode(new int[] {1,2,3,3,4,4,5})));
//		printLinkList(solution0082.deleteDuplicates(generateListNode(new int[] {1,1,1,2,3,3})));
//		printLinkList(solution0082.deleteDuplicates(generateListNode(new int[] {1,1})));

//		Solution0061 solution0061 = new Solution0061();
//		printLinkList(solution0061.rotateRight(generateListNode(new int[] {1,2,3,4,5}), 1));
//		printLinkList(solution0061.rotateRight(generateListNode(new int[] {1,2,3,4,5}), 2));
//		printLinkList(solution0061.rotateRight(generateListNode(new int[] {1,2,3,4,5}), 3));
//		printLinkList(solution0061.rotateRight(generateListNode(new int[] {1,2,3,4,5}), 4));
//		printLinkList(solution0061.rotateRight(generateListNode(new int[] {1,2,3,4,5}), 5));
//		printLinkList(solution0061.rotateRight(generateListNode(new int[] {0,1,2}), 4));
//		printLinkList(solution0061.rotateRight(generateListNode(new int[] {0}), 4));

//		Solution0086 solution0086 = new Solution0086();

//		printLinkList(solution0086.partition(generateListNode(new int[] {1,4,3,2,5,2}), 3));
//		printLinkList(solution0086.partition(generateListNode(new int[] {1,4,3,2,5,2}), 2));
//		printLinkList(solution0086.partition(generateListNode(new int[] {1,4,3,2,5,2, 1}), 5));
//		printLinkList(solution0086.partition(generateListNode(new int[] {2,1}), 2));
//		printLinkList(solution0086.partition(generateListNode(new int[] {}), 2));
		//[1,0,2,2,4,3,5]
//		printLinkList(solution0086.partition(generateListNode(new int[] {1,4,3,0,2,5,2}), 3));
//		Solution0025 solution0025 = new Solution0025();
//		printLinkList(solution0025.reverseKGroup(generateListNode(new int[] {1,2,3,4,5}), 3));
//		printLinkList(solution0025.reverseKGroup(generateListNode(new int[] {1,2,3,4,5,6}), 3));
//		printLinkList(solution0025.reverseKGroup(generateListNode(new int[] {1,2,3}), 3));
//		printLinkList(solution0025.reverseKGroup(generateListNode(new int[] {1,2,3,4,5}), 2));
//		printLinkList(solution0025.reverseKGroup(generateListNode(new int[] {1}), 1));
//		printLinkList(solution0025.reverseKGroup(generateListNode(new int[] {1,2,3}), 1));

//		Solution0105 solution0105 = new Solution0105();
//		int[] preOrder = new int[] {3,9,20,15,7};
//		int[] inOrder = new int[] {9,3,15,20,7};
//		printTree(solution0105.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));
//		printTree(solution0105.buildTree(new int[] {-1}, new int[] {-1}));
//		printTree(solution0105.buildTree(new int[] {1,2,3}, new int[] {3,2,1}));
//		TreeNode res = solution0105.buildTree(new int[] {1,2,3}, new int[] {3,2,1});
		//printTree(res);

//		Solution0106 solution0106 = new Solution0106();
		//[9,3,15,20,7], postorder = [9,15,7,20,3]
//		printTree(solution0106.buildTree(new int[] {9,3,15,20,7}, new int[] {9,15,7,20,3}));
//		printTree(solution0106.buildTree(new int[] {-1}, new int[] {-1}));
//		printTree(solution0106.buildTree(new int[] {3,2,1}, new int[] {3,2,1}));

		//[1,2,5,3,4,null,6]
//		Solution0114 solution0114 = new Solution0114();
//		TreeNode root = generateTree(new Integer[] {1,2,5,3,4,null,6});
//		TreeNode root = generateTree(new Integer[] {0});
//		solution0114.flatten(root);

//		Solution0112 solution0112 = new Solution0112();
//		TreeNode root = generateTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1});
//		System.out.println(solution0112.hasPathSum(root, 22));
//		System.out.println(solution0112.hasPathSum(generateTree(new Integer[]{1, 2, 3}), 5));

//		Solution0129 solution0129 = new Solution0129();
		//System.out.println(solution0129.sumNumbers(generateTree(new Integer[]{4, 9, 0, 5, 1})));
//		System.out.println(solution0129.sumNumbers(generateTree(new Integer[]{1})));

//		Solution0124 solution0124 = new Solution0124();
//		System.out.println(solution0124.maxPathSum(generateTree(new Integer[]{1, 2, 3})));
		//[-10,9,20,null,null,15,7]
//		System.out.println(solution0124.maxPathSum(generateTree(new Integer[]{-10,9,20,null,null,15,7})));
		//[5,4,8,11,null,13,4,7,2,null,null,null,1]
//		System.out.println(solution0124.maxPathSum(generateTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1})));

//		Solution0222 solution0222 = new Solution0222();
//		System.out.println(solution0222.countNodes(generateTree(new Integer[]{1, 2, 3, 4, 5, 6})));
//		System.out.println(solution0222.countNodes(generateTree(new Integer[]{})));
//		System.out.println(s
//		olution0222.countNodes(generateTree(new Integer[]{1})));

//		Solution0236 solution0236 = new Solution0236();
//		System.out.println(solution0236.lowestCommonAncestor(
//			generateTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(1)).val);
//
//		System.out.println(solution0236.lowestCommonAncestor(
//			generateTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(4)).val);

//		Solution0199 solution0199 = new Solution0199();
//		System.out.println(solution0199.rightSideView(generateTree(new Integer[]{1, 2, 3, null, 5, null, 4})));
		//1,2,3,4,null,null,null,5
//		System.out.println(solution0199.rightSideView(generateTree(new Integer[]{1,2,3,4,null,null,null,5})));
//		System.out.println(solution0199.rightSideView(generateTree(new Integer[]{1,null, 3})));
//		System.out.println(solution0199.rightSideView(generateTree(new Integer[]{})));

//		Solution0637 solution0637 = new Solution0637();
//		System.out.println(solution0637.averageOfLevels(generateTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
//		System.out.println(solution0637.averageOfLevels(generateTree(new Integer[]{3,9,20,15,7})));

//		Solution0102 solution0102 = new Solution0102();
//		System.out.println(solution0102.levelOrder(generateTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
//		System.out.println(solution0102.levelOrder(generateTree(new Integer[]{1})));
//		System.out.println(solution0102.levelOrder(generateTree(new Integer[]{})));

//		Solution0103 solution0103 = new Solution0103();
//		System.out.println(solution0103.zigzagLevelOrder(generateTree(new Integer[]{3, 9, 20, null, null, 15, 7})));

//		Solution0530 solution0530 = new Solution0530();
//		System.out.println(solution0530.getMinimumDifference(generateTree(new Integer[]{4, 2, 6, 1, 3})));
//		//1,0,48,null,null,12,49
//		System.out.println(solution0530.getMinimumDifference(generateTree(new Integer[]{1,0,48,null,null,12,49})));
//		//[236,104,701,null,227,null,911]
//		System.out.println(solution0530.getMinimumDifference(generateTree(new Integer[]{236,104,701,null,227,null,911})));
//
//		System.out.println(solution0530.getMinimumDifference2(generateTree(new Integer[]{4, 2, 6, 1, 3})));
//		//1,0,48,null,null,12,49
//		System.out.println(solution0530.getMinimumDifference2(generateTree(new Integer[]{1,0,48,null,null,12,49})));
//		//[236,104,701,null,227,null,911]
//		System.out.println(solution0530.getMinimumDifference2(generateTree(new Integer[]{236,104,701,null,227,null,911})));

//		Solution0230 solution0230 = new Solution0230();
//		System.out.println(solution0230.kthSmallest(generateTree(new Integer[]{3, 1, 4, null, 2}), 1));
//		System.out.println(solution0230.kthSmallest(generateTree(new Integer[]{5,3,6,2,4,null,null,1}), 3));
		//5,3,6,2,4,null,null,1], k = 3
//		Solution0098 solution0098 = new Solution0098();
//		System.out.println(solution0098.isValidBST(generateTree(new Integer[]{2, 1, 3})));
//		System.out.println(solution0098.isValidBST(generateTree(new Integer[]{5,1,4,null,null,3,6})));

		//grid = [
		//  ["1","1","1","1","0"],
		//  ["1","1","0","1","0"],
		//  ["1","1","0","0","0"],
		//  ["0","0","0","0","0"]

//		Solution0200 solution0200 = new Solution0200();
//		char [][] grid = new char[][]  {
//			{'1','1','1','1','0'},
//			{'1','1','0','1','0'},
//			{'1','1','0','0','0'},
//			{'0','0','0','0','0'}};
//		char [][] grid = new char[][]{
//			{'1', '1', '0', '0', '0'},
//			{'1', '1', '0', '0', '0'},
//			{'0', '0', '1', '0', '0'},
//			{'0', '0', '0', '1', '1'}
//		};
//		char[][] grid = new char[][] {{'1'}};
//		char[][] grid = new char[][] {{'0'}};
//		System.out.println(solution0200.numIslands(grid));

//		Solution0130 solution0130 = new Solution0130();
//		char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//		char[][] board = new char[][] {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
//		solution0130.solve(new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
//		solution0130.solve(board);

		//equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
		//equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//		String[][] equations = new String[][] {
//			{"a", "b"},
//			{"b", "c"},
//			{"bc", "cd"}
//		};
//
//		double[] values = new double[] {1.5,2.5,5.0};
//		String [][] queries = new String[][] {
//			{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}
//		};
//		Solution0399 solution0399 = new Solution0399();
//		double[] res = solution0399.calcEquation(arr2List(equations), values, arr2List(queries));
//		for (double re : res) {
//			System.out.print(re + " ");
//		}
//		System.out.println();

//		Solution0207 solution0207 = new Solution0207();
////numCourses = 2, prerequisites = [[1,0]]
//		System.out.println(solution0207.canFinish(2, new int[][]{{1, 0}}));
//		System.out.println(solution0207.canFinish(2, new int[][]{{1, 0}, {0,1}}));
//		//[[1,4],[2,4],[3,1],[3,2]]
//		System.out.println(solution0207.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
//		System.out.println(solution0207.canFinish(2, new int[][]{}));

		Solution0210 solution0207 = new Solution0210();
//numCourses = 2, prerequisites = [[1,0]]
//		int[] res = solution0207.findOrder(2, new int[][]{{1, 0}});
//		for (int re : res) {
//			System.out.println(re);
//		}
//		System.out.println(solution0207.findOrder(2, new int[][]{{1, 0}, {0,1}}));
		//[[1,4],[2,4],[3,1],[3,2]]
//		int[] res2 = solution0207.findOrder(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}});
//		for (int i : res2) {
//			System.out.println(i);
//		}
//		System.out.println(solution0207.findOrder(2, new int[][]{}));
		//1[[1,0],[1,2],[0,1]]
//		int[] res = solution0207.findOrder(3, new int[][]{{1, 0}, {1,2}, {0,1}});
//		for (int re : res) {
//			System.out.println(re);
//		}

//		Solution0017 solution0017 = new Solution0017();
//		System.out.println(solution0017.letterCombinations("23"));
//		System.out.println(solution0017.letterCombinations(""));
//		System.out.println(solution0017.letterCombinations("2"));

		//start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
		Solution0433 solution0433 = new Solution0433();
//		System.out.println(solution0433.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
		//start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
//		System.out.println(solution0433.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
		//start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//		System.out.println(solution0433.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
//		System.out.println(solution0433.minMutation("AACCGGTT", "AACCGGTA", new String[]{}));
//		System.out.println(solution0433.minMutation("AAAAAAAA", "CCCCCCCC",
//			new String[]{"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC",
//			"AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA"}));
//		System.out.println(solution0433.minMutation("AAAACCCC", "CCCCCCCC", new String[]{
//			"AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"
//		}));
//		Solution0909 solution0909 = new Solution0909();
//		int[][] board = new int[][] {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},
//			{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
//		int[][] board = new int[][] {{-1,-1}, {-1,3}};
//		int[][] board = new int[][] {{1,1,-1},{1,1,1},{-1,1,1}};

//		int[][] board = new int[][] {{-1,-1,19,10,-1},{2,-1,-1,6,-1},{-1,17,-1,19,-1},{25,-1,20,-1,-1},{-1,-1,-1,-1,15}};
//		System.out.println(solution0909.snakesAndLadders(board));

//		Solution0077 solution0077 = new Solution0077();
//		System.out.println(solution0077.combine(4, 2));
//		System.out.println(solution0077.combine(1, 1));

//		Solution0046 solution0046 = new Solution0046();
//		System.out.println(solution0046.permute(new int[]{1, 2, 3}));
//		System.out.println(solution0046.permute(new int[]{0,1}));
//		Solution0039 solution0039 = new Solution0039();
//		System.out.println(solution0039.combinationSum(new int[]{2, 3, 6, 7}, 7));
//		System.out.println(solution0039.combinationSum(new int[]{2, 3,5}, 8));
//		System.out.println(solution0039.combinationSum(new int[]{2}, 1));

//		Solution0022 solution0022 = new Solution0022();
//		System.out.println(solution0022.generateParenthesis(3));
//		System.out.println(solution0022.generateParenthesis(1));

//		Solution0079 solution0079 = new Solution0079();
//		char[][] board = new char[][] {
//			{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
//			{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}
//		};
//		System.out.println(solution0079.exist(board, "ABCCED"));
//		System.out.println(solution0079.exist(board, "SEE"));
//		System.out.println(solution0079.exist(board, "ABCB"));
//		System.out.println(solution0079.exist(board, "ABCESEEEFS"));
//		char[][] board = new char[][] {
//			{'a', 'b'}, {'c', 'd'}
//		};
//		System.out.println(solution0079.exist(board, "acdb"));
//		char[][] board = new char[][] {
//			{'a'}
//		};
//		System.out.println(solution0079.exist(board, "a"));

//		Solution0052 solution0052 = new Solution0052();
//		System.out.println(solution0052.totalNQueens(4));

		//"dot","dog","lot","log","cog"
		Solution0127 solution0127 = new Solution0127();
		List<String> wordList = new ArrayList<>() {
			{add("hot");add("dog");add("lot");add("log");add("cog");}
		};
		System.out.println(solution0127.ladderLength("hit", "cog", wordList));

		System.out.println("Java R3");
	}

	public static List<List<String>> arr2List(String[][] arr) {
		List<List<String>> res = new ArrayList<>();
		for (String[] strings : arr) {
			List<String> rs = new ArrayList<>();
			for (String string : strings) {
				rs.add(string);
			}
			res.add(rs);
		}

		return res;
	}

	public static TreeNode generateTree(Integer[] treeArr) {
		if (treeArr.length == 0) {
			return null;
		}
		TreeNode node = new TreeNode(treeArr[0]);

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(node);

		int k = 1;
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			if (k < treeArr.length && treeArr[k] != null) {
				TreeNode l = new TreeNode(treeArr[k]);
				t.left = l;
				queue.add(l);
			}
			k++;

			if (k < treeArr.length && treeArr[k] != null) {
				TreeNode r = new TreeNode(treeArr[k]);
				t.right = r;
				queue.add(r);
			}
			k++;
		}

		return node;
	}

	public static ListNode generateListNode(int[] a) {
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		for (int i : a) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		return head.next;
	}

	public static void printLinkList(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}

		System.out.println();
	}

	public static void printTree(TreeNode treeNode) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(treeNode);

		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			if (t != null) {
				System.out.print(t.val + " ");
				queue.add(t.left);
				queue.add(t.right);
			} else {
				System.out.print("null ");
			}
		}
		System.out.println();
	}
}
