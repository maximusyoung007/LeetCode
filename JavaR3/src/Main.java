import com.sun.source.tree.Tree;
import solution.ListNode;
import solution.Solution0002;
import solution.Solution0019;
import solution.Solution0020;
import solution.Solution0021;
import solution.Solution0025;
import solution.Solution0056;
import solution.Solution0057;
import solution.Solution0061;
import solution.Solution0071;
import solution.Solution0082;
import solution.Solution0086;
import solution.Solution0092;
import solution.Solution0100;
import solution.Solution0101;
import solution.Solution0105;
import solution.Solution0106;
import solution.Solution0112;
import solution.Solution0114;
import solution.Solution0124;
import solution.Solution0129;
import solution.Solution0150;
import solution.Solution0155;
import solution.Solution0224;
import solution.Solution0226;
import solution.Solution0452;
import solution.TreeNode;

import java.util.LinkedList;
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

		Solution0124 solution0124 = new Solution0124();
		System.out.println(solution0124.maxPathSum(generateTree(new Integer[]{1, 2, 3})));
		//[-10,9,20,null,null,15,7]
		System.out.println(solution0124.maxPathSum(generateTree(new Integer[]{-10,9,20,null,null,15,7})));
		//[5,4,8,11,null,13,4,7,2,null,null,null,1]
		System.out.println(solution0124.maxPathSum(generateTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1})));

		System.out.println("Java R3");
	}

	public static TreeNode generateTree(Integer[] treeArr) {
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
