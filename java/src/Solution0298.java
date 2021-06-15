import dataStructure.TreeNode;

import java.util.Stack;

/**
 * 给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。
 *
 * 该路径，可以是从某个初始结点到树中任意结点，通过「父 - 子」关系连接而产生的任意路径。
 *
 * 这个最长连续的路径，必须从父结点到子结点，反过来是不可以的。
 *
 * 示例 1：
 * 输入:
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * 输出: 3
 * 解析: 当中，最长连续序列是 3-4-5，所以返回结果为 3
 *
 * 示例 2：
 * 输入:
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 *
 * 输出: 2
 * 解析: 当中，最长连续序列是 2-3。注意，不是 3-2-1，所以返回 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0298 {
    int len = 0, maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        if (root != null) {
            s1.push(root);
        }
        while (!s1.empty()) {
            TreeNode n1 = s1.pop();
            if (n1.right != null) {
                s1.push(n1.right);
            }
            if (n1.left != null) {
                s1.push(n1.left);
            }
            findPath(n1);
        }

        return maxLen + 1;
    }

    public void findPath(TreeNode root) {
        if (root != null) {
            //以root为节点判断最长路径
            if (root.left != null && root.left.val == root.val + 1) {
                len++;
                if (len > maxLen) {
                    maxLen = len;
                }
                findPath(root.left);
                len--;
            }
            if (root.right != null && root.right.val == root.val + 1) {
                len++;
                if (len > maxLen) {
                    maxLen = len;
                }
                findPath(root.right);
                len--;
            }
        }
    }
}
