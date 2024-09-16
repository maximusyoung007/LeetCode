import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0637 {
	public List<Double> averageOfLevels(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Double> res = new ArrayList<>();

		queue.add(root);

		int count;
		while (!queue.isEmpty()) {
			count = queue.size();

			long sum = 0;
			for (int i = 0; i < count; i++) {
				TreeNode t = queue.poll();
				sum += t.val;
				if (t.left != null) {
					queue.add(t.left);
				}
				if (t.right != null) {
					queue.add(t.right);
				}
			}
			res.add((double)sum / (double)count);
		}

		return res;
	}


}
