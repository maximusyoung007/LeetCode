import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Node2 {
    public int val;
    public List<Node2> children;

    public Node2(){}

    public Node2(int val) {
        this.val = val;
    }

    public Node2(int val, List<Node2> children) {
        this.val = val;
        this.children = children;
    }
}
public class Solution0429 {
    public List<List<Integer>> levelOrder(Node2 root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Node2> firstLayer = new ArrayList<>();
        firstLayer.add(root);
        while (!firstLayer.isEmpty()) {
            List<Node2> secondLayer = new ArrayList<>();
            List<Integer> partResult = new ArrayList<>();
            for (int i = 0; i < firstLayer.size(); i++) {
                partResult.add(firstLayer.get(i).val);
                if (firstLayer.get(i).children != null) {
                    secondLayer.addAll(firstLayer.get(i).children);
                }
            }
            result.add(partResult);
            firstLayer = secondLayer;
        }
        return result;
    }
}
