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
		Solution0380.RandomizedSet randomizedSet = new Solution0380.RandomizedSet();
		//test1
//		System.out.println(randomizedSet.insert(1));
//		System.out.println(randomizedSet.remove(2));
//		System.out.println(randomizedSet.insert(2));
//		System.out.println(randomizedSet.getRandom());
//		System.out.println(randomizedSet.remove(1));
//		System.out.println(randomizedSet.insert(2));
//		System.out.println(randomizedSet.getRandom());

		//test2
		System.out.println(randomizedSet.insert(0));
		System.out.println(randomizedSet.insert(1));
		System.out.println(randomizedSet.remove(0));
		System.out.println(randomizedSet.insert(2));
		System.out.println(randomizedSet.remove(1));
		System.out.println(randomizedSet.getRandom());

//		Solution0146 solution0146 = new Solution0146();
//		Solution0146.LRUCache lRUCache = new Solution0146.LRUCache(2);
//		lRUCache.put(1, 1); // 缓存是 {1=1}
//		lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//		System.out.println(lRUCache.get(1));
//		lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//		System.out.println(lRUCache.get(2));
//		lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//		System.out.println(lRUCache.get(1));
//		System.out.println(lRUCache.get(3));
//		System.out.println(lRUCache.get(4));

		//test2
//		lRUCache.put(2,1);
//		lRUCache.put(1,1);
//		lRUCache.put(2,3);
//		lRUCache.put(4,1);
//		System.out.println(lRUCache.get(1));
//		System.out.println(lRUCache.get(2));

		//test3
//		System.out.println(lRUCache.get(6));
//		System.out.println(lRUCache.get(8));
//		lRUCache.put(12,1);
//		System.out.println(lRUCache.get(2));
//		lRUCache.put(15,11);
//		lRUCache.put(5,2);
//		lRUCache.put(1,15);
//		lRUCache.put(4,2);
//		System.out.println(lRUCache.get(4));
//		lRUCache.put(15,15);

		//test4
//		lRUCache.put(1,1);
//		lRUCache.put(2,2);
//		System.out.println(lRUCache.get(1));
//		lRUCache.put(3,3);
//		System.out.println(lRUCache.get(2));
//		lRUCache.put(4,4);
//		System.out.println(lRUCache.get(1));
//		System.out.println(lRUCache.get(3));
//		System.out.println(lRUCache.get(4));
//		int[][] edges = new int[][] {
//			{1,2}, {2,3}, {3,4}, {1,4}, {1,5}
//		};
//		Solution0684 solution0684 = new Solution0684();
//		int[][] edges = new int[][] {
//			{1,2}, {1,3}, {2,3}
//		};
//		Solution0684 solution0684 = new Solution0684();
//		int[] res = solution0684.findRedundantConnection(edges);
//		for (int re : res) {
//			System.out.println(re);
//		}

//		int n = 4;
//		int[][] connections = new int[][] {
//			{1,2,3},
//			{3,4,4}
//		};

//		int n = 3;
//		int[][] connections = new int[][] {
//			{1,2,5},
//			{1,3,6},
//			{2,3,1}
//		};
//		Solution1135Kruskal solution1135Kruskal = new Solution1135Kruskal();
//		System.out.println(solution1135Kruskal.minimumCost(n, connections));
//
//		Solution1135Prim solution1135 = new Solution1135Prim();
//		System.out.println(solution1135.minimumCost(n, connections));

//		int[][] edges = new int[][] {
//			{0,1}, {0,3}, {1,2}, {2,1}
//		};
//		int n = 4;
//		int source = 0;
//		int destination = 3;

//		int[][] edges = new int[][] {
//			{0,1}, {0,2}
//		};
//		int n = 3;
//		int source = 0;
//		int destination = 2;
//
//		int[][] edges = new int[][] {
//			{0,1}, {0,2}, {1,3}, {2,3}
//		};
//		int n = 4;
//		int source = 0;
//		int destination = 3;

//		int[][] edges = new int[][] {
//			{0,1}, {1,1}
//		};
//		int n = 2;
//		int source = 0;
//		int destination = 1;

//		Solution1059 solution1059 = new Solution1059();
//		System.out.println(solution1059.leadsToDestination(n, edges, source, destination));

//		int[][] pre = new int[][] {
//			{1,0}
//		};
//		int numCourses = 2;
//		int[][] pre = new int[][] {
//
//		};
//		int numCourses = 2;

//		Solution0210 solution0210 = new Solution0210();
//		int[] res = solution0210.findOrder(numCourses, pre);
//		for (int re : res) {
//			System.out.println(re);
//		}

//		Set<String> s1 = new HashSet<>();
//		s1.add("hello");
//		TestSet ts1 = new TestSet();
//		TestSet ts2 = new TestSet();
//
//		ts1.setSetTest(s1);
//		ts2.setSetTest(new HashSet<>(Arrays.asList("hello")));
//
//		System.out.println();

//		TreeNode node1 = new TreeNode(1);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(0);
//		TreeNode node5 = new TreeNode(2);
//		TreeNode node6 = new TreeNode(5);
//		TreeNode node7 = new TreeNode(7);
//		TreeNode node8 = new TreeNode(3);
//		TreeNode node9 = new TreeNode(8);
//		node1.right = node2;
//		node2.left = node3;
//		Solution0094 solution0094 = new Solution0094();
//		List<Integer> res = solution0094.inorderTraversal(node1);
//		node2.left = node4;
//		node2.right = node5;
//		node3.left = node6;
//		node3.right = node7;
//		node5.right = node8;
//		node7.right = node9;
//		Solution0538 solution0538 = new Solution0538();
//		solution0538.convertBST(node1);
//		Solution0513 solution0513 = new Solution0513();
//		System.out.println(solution0513.findBottomLeftValue(node1));
//		TreeNode node1 = new TreeNode(3);
//		TreeNode node2 = new TreeNode(9);
//		TreeNode node3 = new TreeNode(20);
//		TreeNode node4 = new TreeNode(15);
//		TreeNode node5 = new TreeNode(7);
//		node1.left = node2;
//		node1.right = node3;
//		node3.left = node4;
//		node3.right = node5;
//		Solution0404 solution0404 = new Solution0404();
//		System.out.println(solution0404.sumOfLeftLeaves(node1));
//		TreeNode node1 = new TreeNode(3);
//		TreeNode node2 = new TreeNode(4);
//		TreeNode node3 = new TreeNode(5);
//		TreeNode node4 = new TreeNode(1);
//		TreeNode node5 = new TreeNode(2);
//		TreeNode node6 = new TreeNode(0);
//		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node5.left = node6;

//		TreeNode l1 = new TreeNode(4);
//		TreeNode l2 = new TreeNode(1);
//		TreeNode l3 = new TreeNode(2);
//		TreeNode l4 = new TreeNode(4);
//		TreeNode l5 = new TreeNode(7);
//		l1.left = l2;
//		l1.right = l3;
//		Solution0572 solution0572 = new Solution0572();
//		System.out.println(solution0572.isSubtree(node1, l1));

//		Solution0226 solution0226 = new Solution0226();
//		TreeNode node1 = new TreeNode(4);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(7);
//		TreeNode node4 = new TreeNode(1);
//		TreeNode node5 = new TreeNode(3);
//		TreeNode node6 = new TreeNode(6);
//		TreeNode node7 = new TreeNode(9);
//		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.left = node6;
//		node3.right = node7;
//		TreeNode res = solution0226.invertTree(node1);

//		Solution0105 solution0105 = new Solution0105();
//		int[] preorder = new int[] {3,9,20,15,7};
//		int[] inorder = new int[] {9,3,15,20,7};
//		int[] preorder = new int[] {-1};
//		int[] inorder = new int[] {-1};
//		TreeNode res = solution0105.buildTree(preorder, inorder);
//		TreeNode node1 = new TreeNode(3);
//		TreeNode node2 = new TreeNode(9);
//		TreeNode node3 = new TreeNode(20);
//		TreeNode node4 = new TreeNode(15);
//		TreeNode node5 = new TreeNode(7);
//		node1.left = node2;
//		node1.right = node3;
//		node3.left = node4;
//		node3.right = node5;
//
//		Solution0637 solution0637 = new Solution0637();
//		List<Double> res = solution0637.averageOfLevels(node1);
//		for (Double re : res) {
//			System.out.println(re);
//		}
//		Solution1110.TreeNode node1 = new Solution1110.TreeNode(1);
//		Solution1110.TreeNode node2 = new Solution1110.TreeNode(2);
//		Solution1110.TreeNode node3 = new Solution1110.TreeNode(3);
//		Solution1110.TreeNode node4 = new Solution1110.TreeNode(4);
//		Solution1110.TreeNode node5 = new Solution1110.TreeNode(5);
//		Solution1110.TreeNode node6 = new Solution1110.TreeNode(6);
//		Solution1110.TreeNode node7 = new Solution1110.TreeNode(7);
//		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.left = node6;
//		node3.right = node7;
//		node1.left = node2;
//		node1.right = node3;
//		node3.right = node4;
//		Solution1110 solution0110 = new Solution1110();
//		List<Solution1110.TreeNode> res = solution0110.delNodes(node1, new int[] {2, 1});

//		Solution0437.TreeNode node1 = new Solution0437.TreeNode(10);
//		Solution0437.TreeNode node2 = new Solution0437.TreeNode(5);
//		Solution0437.TreeNode node3 = new Solution0437.TreeNode(-3);
//		Solution0437.TreeNode node4 = new Solution0437.TreeNode(3);
//		Solution0437.TreeNode node5 = new Solution0437.TreeNode(2);
//		Solution0437.TreeNode node6 = new Solution0437.TreeNode(11);
//		Solution0437.TreeNode node7 = new Solution0437.TreeNode(3);
//		Solution0437.TreeNode node8 = new Solution0437.TreeNode(-2);
//		Solution0437.TreeNode node9 = new Solution0437.TreeNode(1);
		//[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
//		System.out.println(-(long)2000000000 - (long)294967296);
//		Solution0437.TreeNode node1 = new Solution0437.TreeNode(1000000000);
//		Solution0437.TreeNode node2 = new Solution0437.TreeNode(1000000000);
//		Solution0437.TreeNode node3 = new Solution0437.TreeNode(294967296);
//		Solution0437.TreeNode node4 = new Solution0437.TreeNode(1000000000);
//		Solution0437.TreeNode node5 = new Solution0437.TreeNode(1000000000);
//		Solution0437.TreeNode node6 = new Solution0437.TreeNode(1000000000);
////		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.right = node6;
//		node4.left = node7;
//		node4.right = node8;
//		node5.right = node9;
//		node1.left = node2;
//		node2.left = node3;
//		node3.left = node4;
//		node4.left = node5;
//		node5.left = node6;
//
//		Solution0437 solution0437 = new Solution0437();
//		System.out.println(solution0437.pathSum(node1, 0));
//		Solution0110 solution0110 = new Solution0110();
//		System.out.println(solution0110.isBalanced(node1));
//		Solution0104 solution0104 = new Solution0104();
//		System.out.println(solution0104.maxDepth(node1));

//		Solution0083 solution0083 = new Solution0083();
//		Solution0083.ListNode node = new Solution0083.ListNode(1);
//		Solution0083.ListNode node2 = new Solution0083.ListNode(1);
//		Solution0083.ListNode node3 = new Solution0083.ListNode(2);
//		Solution0083.ListNode node4 = new Solution0083.ListNode(3);
//		Solution0083.ListNode node5 = new Solution0083.ListNode(3);
//		node.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		Solution0083.ListNode res = solution0083.deleteDuplicates(node);
//		Solution0328 solution0328 = new Solution0328();
		//[2,1,3,5,6,4,7]
//		Solution0328.ListNode node = new Solution0328.ListNode(1);
//		Solution0328.ListNode node2 = new Solution0328.ListNode(2);
//		Solution0328.ListNode node3 = new Solution0328.ListNode(3);
//		Solution0328.ListNode node4 = new Solution0328.ListNode(4);
//		Solution0328.ListNode node5 = new Solution0328.ListNode(5);
//		Solution0328.ListNode node = new Solution0328.ListNode(2);
//		Solution0328.ListNode node2 = new Solution0328.ListNode(1);
//		Solution0328.ListNode node3 = new Solution0328.ListNode(3);
//		Solution0328.ListNode node4 = new Solution0328.ListNode(5);
//		Solution0328.ListNode node5 = new Solution0328.ListNode(6);
//		Solution0328.ListNode node6 = new Solution0328.ListNode(4);
//		Solution0328.ListNode node7 = new Solution0328.ListNode(7);
//		node.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
//		Solution0328.ListNode res = solution0328.oddEvenList(node);
//		Solution0019 solution0019 = new Solution0019();
//		Solution0019.ListNode node = new Solution0019.ListNode(1);
//		Solution0019.ListNode node1 = new Solution0019.ListNode(2);
//		Solution0019.ListNode node2 = new Solution0019.ListNode(3);
//		Solution0019.ListNode node3 = new Solution0019.ListNode(4);
//		Solution0019.ListNode node4 = new Solution0019.ListNode(5);
//		node.next = node1;
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4
//		;
//		Solution0019.ListNode res = solution0019.removeNthFromEnd(node, 1);
//		Solution0148 solution0148 = new Solution0148();
//		Solution0148.ListNode node1 = new Solution0148.ListNode(4);
//		Solution0148.ListNode node2 = new Solution0148.ListNode(2);
//		Solution0148.ListNode node3 = new Solution0148.ListNode(1);
//		Solution0148.ListNode node4 = new Solution0148.ListNode(3);
//		Solution0148.ListNode node5 = new Solution0148.ListNode(3);
//		Solution0148.ListNode node1 = new Solution0148.ListNode(3);
//		Solution0148.ListNode node2 = new Solution0148.ListNode(4);
//		Solution0148.ListNode node3 = new Solution0148.ListNode(1);
//		Solution0148.ListNode node4 = new Solution0148.ListNode(4);
//		Solution0148.ListNode node5 = new Solution0148.ListNode(0);
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		Solution0148.ListNode res = solution0148.sortList(node1);
//		while (res != null) {
//			System.out.println(res.val);
//			res = res.next;
//		}
//		Solution0234 solution0234 = new Solution0234();
//		Solution0234.ListNode node = new Solution0234.ListNode(1);
//		Solution0234.ListNode node2 = new Solution0234.ListNode(3);
//		Solution0234.ListNode node3 = new Solution0234.ListNode(2);
//		Solution0234.ListNode node4 = new Solution0234.ListNode(3);
//		Solution0234.ListNode node5= new Solution0234.ListNode(1);
//		node.next = node2;
//		node2.next = node3;
//		node3.next = node4;
////		node4.next = node5;
//		System.out.println(solution0234.isPalindrome(node));
//		Solution0024 solution0024 = new Solution0024();
//		Solution0024.ListNode node = new Solution0024.ListNode(1);
//		Solution0024.ListNode node1 = new Solution0024.ListNode(2);
//		Solution0024.ListNode node2 = new Solution0024.ListNode(3);
//		Solution0024.ListNode node3 = new Solution0024.ListNode(4);
//		node.next = node1;
//		node1.next = node2;
//		node2.next = node3;
//		Solution0024.ListNode res = solution0024.swapPairs(node);
//		while (res != null) {
//			System.out.println(res.val);
//			res = res.next;
//		}
//		Solution0021 solution0021 = new Solution0021();
//		Solution0021.ListNode n1 = new Solution0021.ListNode(1);
//		Solution0021.ListNode n2 = new Solution0021.ListNode(2);
//		Solution0021.ListNode n3 = new Solution0021.ListNode(4);
//		n1.next = n2;
//		n2.next = n3;
//		Solution0021.ListNode l1 = new Solution0021.ListNode(1);
//		Solution0021.ListNode l2 = new Solution0021.ListNode(3);
//		Solution0021.ListNode l3 = new Solution0021.ListNode(4);
//		l1.next = l2;
//		l2.next = l3;
//
//		Solution0021.ListNode res = solution0021.mergeTwoLists(n1, l1);
//		while (res != null) {
//			System.out.println(res.val);
//			res = res.next;
//		}
//		Solution0206 solution0206 = new Solution0206();
//		Solution0206.ListNode node = new Solution0206.ListNode(1);
//		Solution0206.ListNode node1 = new Solution0206.ListNode(2);
//		Solution0206.ListNode node2 = new Solution0206.ListNode(3);
//		Solution0206.ListNode node3 = new Solution0206.ListNode(4);
//		Solution0206.ListNode node4 = new Solution0206.ListNode(5);
//		node.next = node1;
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		Solution0206.ListNode res = solution0206.reverseList(node);
//		while (res != null) {
//			System.out.println(res.val);
//			res = res.next;
//		}
//		Solution0005 solution0005 = new Solution0005();
//		System.out.println(solution0005.longestPalindrome("babad"));
//		System.out.println(solution0005.longestPalindrome("cbbd"));
//		System.out.println(solution0005.longestPalindrome("babaabaa"));
//		Solution0772 solution0772 = new Solution0772();
//		System.out.println(solution0772.calculate("2*(5+5*2)/3+(6/2+8)"));
//		System.out.println(solution0772.calculate("1+1"));
//		System.out.println(solution0772.calculate("6-4/2"));
//		System.out.println(solution0772.calculate("((((1*10)-(3*8))*3)*1)"));
//		Solution0003 solution0003 = new Solution0003();
//		System.out.println(solution0003.lengthOfLongestSubstring("abcabcbb"));
//		System.out.println(solution0003.lengthOfLongestSubstring("bbbbb"));
//		System.out.println(solution0003.lengthOfLongestSubstring("pwwkew"));
//		System.out.println(solution0003.lengthOfLongestSubstring("a"));
//		System.out.println(solution0003.lengthOfLongestSubstring("aa"));
//		System.out.println(solution0003.lengthOfLongestSubstring("ab"));
//		System.out.println(solution0003.lengthOfLongestSubstring("abba"));
//		Solution0409 solution0409 = new Solution0409();
//		solution0409
//		System.out.println(solution0409.longestPalindrome("abccccdd"));
//		Solution0028 solution0028 = new Solution0028();
//		String s1 = "sadbutsad";
//		String s2 = "sad";
//		String s1 = "aabaabaaf";
//		String s2 = "aabaaf";
//		System.out.println(solution0028.strStr(s1, s2));
//		Solution0227 solution0227 = new Solution0227();
//		String s = "3+5 / 2";
//		String s = "42";
//		System.out.println(solution0227.calculate(s));
//		Solution0647 solution0647 = new Solution0647();
//		System.out.println(solution0647.countSubstrings("abc"));
//		System.out.println(solution0647.countSubstrings("fdsklf"));
//		int[] nums = new int[] {1,3,4,2,2};
		//3,4,2,3,
//		int[] nums = new int[] {3,1,3,4,2};
//		int[] nums = new int[] {0,9,5,7,3};
//		Solution0287 solution0287 = new Solution0287();
//		System.out.println(solution0287.findDuplicate(nums));
//		Solution0503 solution0503 = new Solution0503();
//		int[] nums = new int[] {1,2,3,4,4,3};
//		int[] nums = new int[] {1,1,1,1,1};
//		int[] nums = new int[] {100,1,11,1,120,111,123,1,-1,-100};
//		int[] res = solution0503.nextGreaterElements(nums);
//		for (int re : res) {
//			System.out.println(re);
//		}

//		Solution0566 solution0566 = new Solution0566();
//		int[][] mat = new int[][] {{1,2},{3,4}};
//		int r = 4, c = 1;
//		int [][] res = solution0566.matrixReshape(mat, r, c);

//		Solution0560 solution0560 = new Solution0560();
//		int[] nums = new int[] {1, 1, 1};
//		int k = 2;
//		int[] nums = new int[] {1, 1};
//		int k = 0;
//		int[] nums = new int[] {1,2,6};
//		int k = 6;
//		System.out.println(solution0560.subarraySum(nums, k));
//		Solution0332 solution0332 = new S
//		olution0332();
//		List<List<String>> list = new ArrayList<>();
//
//		List<String> t1 = new ArrayList<>();
//		t1.add("JFK");
//		t1.add("AAA");
//		list.add(t1);
//
//		List<String> t2 = new ArrayList<>();
//		t2.add("JFK");
//		t2.add("BBB");
//		list.add(t2);
//
//		List<String> t3 = new ArrayList<>();
//		t3.add("BBB");
//		t3.add("JFK");
//		list.add(t3);

//		List<String> t4 = new ArrayList<>();
//		t4.add("AAA");
//		t4.add("JFK");
//		list.add(t4);

//		List<List<String>> list = new ArrayList<>();
//
//		List<String> t1 = new ArrayList<>();
//		t1.add("MUC");
//		t1.add("LHR");
//		list.add(t1);
//
//		List<String> t2 = new ArrayList<>();
//		t2.add("JFK");
//		t2.add("MUC");
//		list.add(t2);
//
//		List<String> t3 = new ArrayList<>();
//		t3.add("SFO");
//		t3.add("SJC");
//		list.add(t3);
//
//		List<String> t4 = new ArrayList<>();
//		t4.add("LHR");
//		t4.add("SFO");
//		list.add(t4);
//		List<String> res = solution0332.findItinerary(list);
//
//		for (String re : res) {
//			System.out.println(re);
//		}

//		Solution0149 solution0149 = new Solution0149();
		//points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
		//(1,4) (2,3) (3,2) (4,1)
//		int[][] point = new int[][] {
//			{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}
//		};
//		int res = solution0149.maxPoints(point);
//		System.out.println(res);
//		ListNode23 node1 = new ListNode23(-2);
//		ListNode23 node2 = new ListNode23(-1);
//		ListNode23 node3 = new ListNode23(-1);
//		ListNode23 node4 = new ListNode23(-1);
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//
//		ListNode23 node5 = new ListNode23();
//
//		ListNode23[] list = new ListNode23[2];
//		list[0] = node1;
//		list[1] = null;
//
//		Solution0023 solution0023 = new Solution0023();
//		ListNode23 res = solution0023.mergeKLists(list);
//		while (res != null) {
//			System.out.println(res.val);
//			res = res.next;
//		}

		System.out.println("end");

//		Solution0023 solution0023 = new Solution0023();


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
