import dataStructure.TreeNode;

/**
 * 给定一个二叉树，统计该二叉树数值相同的子树个数。
 *
 * 同值子树是指该子树的所有节点都拥有相同的数值。
 *
 * 示例：
 *
 * 输入: root = [5,1,5,5,5,null,5]
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-univalue-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0250 {
    int count = 0;
    boolean isSameValueTree(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        boolean nodeSame = true;
        if (node.left != null) {
            nodeSame = isSameValueTree(node.left) && nodeSame && node.val == node.left.val;
        }
        if (node.right != null) {
            nodeSame = isSameValueTree(node.right) && nodeSame && node.val == node.right.val;
        }
        if (!nodeSame) {
            return false;
        } else {
            count++;
            return true;
        }
    }
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        isSameValueTree(root);
        return count;
    }
}
