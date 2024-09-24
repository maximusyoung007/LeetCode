import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author maximusyoung
 */
public class Solution0513 {
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int res = 0;
		while (!queue.isEmpty()) {
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				TreeNode t = queue.poll();
				if (i == 0) {
					res = t.val;
				}
				if (t.left != null) {
					queue.add(t.left);
				}
				if (t.right != null) {
					queue.add(t.right);
				}
			}
		}

		return res;
	}
}
