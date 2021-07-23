import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 *
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 *
 * 输入: []
 * 输出: []
 *  
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//层序遍历
public class Solution0199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root);
        //使用size记录每层节点数，当size为0，说明这一层遍历结束了，此时队列中的变量都是下一层的节点
        int size = queue1.size();
        while (!queue1.isEmpty()) {
            TreeNode t = queue1.poll();
            size--;
            if (t.left != null) {
                queue1.add(t.left);
            }
            if (t.right != null) {
                queue1.add(t.right);
            }
            if (size == 0) {
                result.add(t.val);
                size = queue1.size();
            }
        }
        return result;
    }
}
