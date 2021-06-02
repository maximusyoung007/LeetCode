import apple.laf.JRSUIUtils;
import dataStructure.TreeNode;

import java.util.*;

/**
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。
 *
 * 注意：
 *
 *     给定的目标值 target 是一个浮点数
 *     你可以默认 k 值永远是有效的，即 k ≤ 总结点数
 *     题目保证该二叉搜索树中只会存在一种 k 个值集合最接近目标值
 *
 * 示例：
 *
 * 输入: root = [4,2,5,1,3]，目标值 = 3.714286，且 k = 2
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * 输出: [4,3]
 *
 * 拓展：
 * 假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（n 为总结点数）的时间复杂度内解决该问题呢？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closest-binary-search-tree-value-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0272 {
    Map<TreeNode, TreeNode> m = new HashMap<>();

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        //保存所有节点的父节点备用
        getParent(root);
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        TreeNode closeNode = root;
        TreeNode root1 = root;
        int closest = root.val;
        while (root1 != null) {
            if (Math.abs(root1.val - target) < Math.abs(closest - target)) {
                closest = root1.val;
                closeNode = root1;
            }
            root1 = root1.val > target ? root1.left : root1.right;
        }
        result.add(closest);
        set.add(closeNode);
        while (result.size() < k) {
            TreeNode preNode = closeNode;
            TreeNode nextNode = closeNode;
            while (k - result.size() >= 2) {
                preNode = getPre(preNode);
                nextNode = getNext(nextNode);
                if (!set.contains(preNode)) {
                    result.add(preNode.val);
                    set.add(preNode);
                }
                if (!set.contains(nextNode)) {
                    result.add(nextNode.val);
                    set.add(nextNode);
                }
            }
            if (result.size() < k) {
                preNode = getPre(preNode);
                nextNode = getNext(nextNode);
                if (set.contains(preNode) && !set.contains(nextNode)) {
                    result.add(nextNode.val);
                    set.add(nextNode);
                } else if (set.contains(nextNode) && !set.contains(preNode)) {
                    result.add(preNode.val);
                    set.add(preNode);
                } else if (!set.contains(preNode) && !set.contains(nextNode)){
                    if (Math.abs(preNode.val - target) <= Math.abs(nextNode.val - target)) {
                        result.add(preNode.val);
                        set.add(preNode);
                    } else {
                        result.add(nextNode.val);
                        set.add(nextNode);
                    }
                }
            }
        }
        return result;
    }

    //获取最接近节点的前一个节点
    public TreeNode getPre(TreeNode root) {
        if (root.left != null) {
            root = root.left;
            while (root.right != null) {
                root = root.right;
            }
        } else  {
            TreeNode root1 = root;
            while (m.containsKey(root1)) {
                TreeNode tNode = m.get(root1);
                if (tNode.val < root1.val) {
                    return tNode;
                }
                root1 = tNode;
            }
        }
        return root;
    }

    //获取最接近节点的后一个节点
    public TreeNode getNext(TreeNode root) {
        if (root.right != null) {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
        } else {
            TreeNode root1 = root;
            while (m.containsKey(root1)) {
                TreeNode tNode = m.get(root1);
                if (tNode.val > root1.val) {
                    return tNode;
                }
                root1 = tNode;
            }
        }
        return root;
    }

    public Map<TreeNode, TreeNode> getParent(TreeNode node) {
        if (node.left != null) {
            m.put(node.left, node);
            getParent(node.left);
        }
        if (node.right != null) {
            m.put(node.right, node);
            getParent(node.right);
        }
        return null;
    }
}
