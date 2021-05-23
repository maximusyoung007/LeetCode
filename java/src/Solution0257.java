import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0257 {
    StringBuilder s = new StringBuilder("");
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(result, s, root);
        return result;
    }

    void dfs(List<String> result, StringBuilder s, TreeNode root) {
        s.append(root.val);
        if (root.left != null) {
            dfs(result, s, root.left);
        }
        s.deleteCharAt(s.length() - 1);
        if (root.right != null) {
            dfs(result, s, root.right);
        }
        s.deleteCharAt(s.length() - 1);
        if (root.left == null && root.right == null) {
            result.add(s.toString());
            return;
        }
    }
}
