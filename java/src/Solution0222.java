import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 *
 * Example 2:
 * Input: root = []
 * Output: 0
 *
 * Example 3:
 * Input: root = [1]
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5 * 104].
 * 0 <= Node.val <= 5 * 104
 * The tree is guaranteed to be complete.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0222 {
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            count++;
            if (t.left != null) {
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }
        }
        return count;
    }
}
