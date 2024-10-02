import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author maximusyoung
 */
public class Solution0094 {
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}

			root = stack.pop();
			res.add(root.val);
			root = root.right;
		}

		return res;
	}
}
