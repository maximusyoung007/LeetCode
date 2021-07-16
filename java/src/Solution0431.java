import dataStructure.Node;
import dataStructure.TreeNode;

import java.util.ArrayList;

/**
 * 设计一个算法，可以将 N 叉树编码为二叉树，并能将该二叉树解码为原 N 叉树。一个 N 叉树是指每个节点都有不超过 N 个孩子节点的有根树。类似地，一个二叉树是指每个节点都有不超过 2 个孩子节点的有根树。你的编码 / 解码的算法的实现没有限制，你只需要保证一个 N 叉树可以编码为二叉树且该二叉树可以解码回原始 N 叉树即可。
 *
 * 例如，你可以将下面的 3-叉 树以该种方式编码：
 *
 *  
 *
 *
 *
 *  
 *
 * 注意，上面的方法仅仅是一个例子，可能可行也可能不可行。你没有必要遵循这种形式转化，你可以自己创造和实现不同的方法。
 *
 * 注意：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/encode-n-ary-tree-to-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//改的别人的python，自己是写不出来的，一辈子也写不出来的
//真-诗一般的代码
public class Solution0431 {
    public TreeNode encode(Node node) {
        if (node == null) {
            return null;
        }
        TreeNode root = new TreeNode(node.val);
        if (node.children != null && !node.children.isEmpty()) {
            root.left = encode(node.children.get(0));
        }
        TreeNode cur = root.left;
        for (int i = 1; i < node.children.size(); i++) {
            cur.right = encode(node.children.get(i));
            cur = cur.right;
        }
        return root;
    }

    public Node decode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        Node root = new Node(treeNode.val, new ArrayList<>());
        TreeNode cur = treeNode.left;
        while (cur != null) {
            root.children.add(decode(cur));
            cur = cur.right;
        }
        return root;
    }
}
