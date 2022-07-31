import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1161 {
	public int maxLevelSum(TreeNode root) {
		int ans = 1, max = Integer.MIN_VALUE;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 1;
		while (!queue.isEmpty()) {
			int sum = 0;
			Queue<TreeNode> queue1 = new LinkedList<>();
			while (!queue.isEmpty()) {
				TreeNode t = queue.poll();
				sum += t.val;
				if (t.left != null) {
					queue1.add(t.left);
				}
				if (t.right != null) {
					queue1.add(t.right);
				}
			}
			if (sum > max) {
				max = sum;
				ans = level;
			}
			queue = queue1;
			level++;
		}
		return ans;
	}
}
