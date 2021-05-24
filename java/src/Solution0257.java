import dataStructure.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution0257 {
    StringBuilder s = new StringBuilder("");
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        List<String> partResult = new ArrayList<>();
        List<String> r = new ArrayList<>();
        dfs(result, partResult, root);
        for (List<String> l : result) {
            String ts = "";
            for (int i = 0; i < l.size() - 1; i++) {
                ts += l.get(i) + "->";
            }
            ts += l.get(l.size() - 1);
            r.add(ts);
        }
        return r;
    }

    void dfs(List<List<String>> result, List<String> partResult, TreeNode root) {
        int val = root.val;
        Integer v = val;
        partResult.add(v.toString());
        if (root.left != null) {
            dfs(result, partResult, root.left);
            partResult.remove(partResult.size() - 1);
        }
        if (root.right != null) {
            dfs(result, partResult, root.right);
            partResult.remove(partResult.size() - 1);
        }
        if (root.left == null && root.right == null) {
            List<String> tempPartResult = new ArrayList<>();
            for (String s : partResult) {
                tempPartResult.add(s);
            }
            result.add(tempPartResult);
            return;
        }
    }
}
