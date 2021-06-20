import dataStructure.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。
 *
 * 如果两个结点在同一行和列，那么顺序则为 从左到右。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 *
 * 示例 2：
 *
 * 输入：root = [3,9,8,4,0,1,7]
 * 输出：[[4],[9],[3,0,1],[8],[7]]
 *
 * 示例 3：
 *
 * 输入：root = [3,9,8,4,0,1,7,null,null,null,2,5]
 * 输出：[[4],[9,5],[3,0,1],[8,2],[7]]
 *
 * 示例 4：
 *
 * 输入：root = []
 * 输出：[]
 *
 * 提示：
 *     树中结点的数目在范围 [0, 100] 内
 *     -100 <= Node.val <= 100
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-vertical-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        //层序遍历，两个队列，同步进出，一个存节点，一个存节点对应的列
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> indexs = new LinkedList<>();
        //map用来存储一列对应的
        Map<Integer, List<Integer>> m = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            nodes.add(root);
            indexs.add(0);
        }
        else {
            return result;
        }
        while (!nodes.isEmpty()) {
            TreeNode t = nodes.peek();
            int index = indexs.peek();
            List<Integer> list = new ArrayList<>();
            if (m.containsKey(index)) {
                list.addAll(m.get(index));
            }
            list.add(t.val);
            m.put(index, list);
            if (t.left != null) {
                nodes.add(t.left);
                indexs.add(index - 1);
            }
            if (t.right != null) {
                nodes.add(t.right);
                indexs.add(index + 1);
            }
            nodes.poll();
            indexs.poll();
        }
        TreeMap<Integer, List<Integer>> m2 = new TreeMap<>(m);
        for (Map.Entry<Integer, List<Integer>> entry : m2.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
