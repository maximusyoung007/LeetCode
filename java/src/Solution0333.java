import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。
 * 二叉搜索树（BST）中的所有节点都具备以下属性：
 * 左子树的值小于其父（根）节点的值。
 * 右子树的值大于其父（根）节点的值。
 *
 * 注意:
 *
 * 子树必须包含其所有后代。
 * 进阶:
 *
 * 你能想出 O(n) 时间复杂度的解法吗？
 *  
 * 示例 1：
 *
 * 输入：root = [10,5,15,1,8,null,7]
 * 输出：3
 * 解释：本例中最大的 BST 子树是高亮显示的子树。返回值是子树的大小，即 3 。
 * 示例 2：
 *
 * 输入：root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-bst-subtree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0333 {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int t = 0, result = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (valid(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                t = cal(node);
                if (t > result) {
                    result = t;
                }
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            queue.poll();
        }
        return result;
    }

    //是否是一颗BST
    boolean valid(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return valid(root.left, left, root.val) && valid(root.right, root.val, right);
    }

    //计算节点的数量
    int cal(TreeNode root) {
        return root != null ? cal(root.left) + cal(root.right) + 1 : 0;
    }
}
