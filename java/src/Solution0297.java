import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0297 {
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder("");
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            if (tn != null) {
                sb.append(tn.val);
                queue.add(tn.left);
                queue.add(tn.right);
            } else {
                sb.append("X");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] data1 = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        Integer r = 0;
        if (!data1[0].equals("X")) {
            r = Integer.parseInt(data1[0]);
        } else {
            return null;
        }
        TreeNode root = new TreeNode(r);
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (!data1[i].equals("X")) {
                int left = Integer.parseInt(data1[i]);
                TreeNode ln = new TreeNode(left);
                n.left = ln;
                queue.add(ln);
            }
            if (!data1[i+1].equals("X")) {
                int right = Integer.parseInt(data1[i+1]);
                TreeNode rn = new TreeNode(right);
                n.right = rn;
                queue.add(rn);
            }
            i += 2;
        }
        return root;
    }
}


