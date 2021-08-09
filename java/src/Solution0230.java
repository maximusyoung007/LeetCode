import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        midOrder(list, root, k);
        return list.get(k - 1);
    }

    public void midOrder(List<Integer> list, TreeNode root, int k) {
        if (root.left != null) {
            midOrder(list, root.left, k);
        }
        list.add(root.val);
        if (list.size() == k) {
            return;
        }
        if (root.right != null) {
            midOrder(list, root.right, k);
        }
    }
}
