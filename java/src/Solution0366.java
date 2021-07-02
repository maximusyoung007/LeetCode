import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一棵二叉树，请按以下要求的顺序收集它的全部节点：
 *
 * 依次从左到右，每次收集并删除所有的叶子节点
 * 重复如上过程直到整棵树为空
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 *  
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * 输出: [[4,5,3],[2],[1]]
 *  
 *
 * 解释:
 *
 * 1. 删除叶子节点 [4,5,3] ，得到如下树结构：
 *
 *           1
 *          /
 *         2
 *  
 *
 * 2. 现在删去叶子节点 [2] ，得到如下树结构：
 *
 *           1
 *  
 *
 * 3. 现在删去叶子节点 [1] ，得到空树：
 *
 *           []
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-leaves-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0366 {
    List<List<Integer>> list = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        getHeight(root);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        int height = Integer.max(l, r) + 1;
        List<Integer> li = new ArrayList<>();
        if (map.containsKey(height)) {
            li = map.get(height);
        }
        li.add(root.val);
        map.put(height, li);
        return height;
    }
}
