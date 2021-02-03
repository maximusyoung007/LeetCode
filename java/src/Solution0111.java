import dataStructure.TreeNode;

public class Solution0111 {
    public int minDepth(TreeNode root) {
        int minD = Integer.MAX_VALUE;
        if(root == null) {
            return 0;
        }
        else if(root.left == null && root.right == null) {
            return 1;
        }
        else {
            if(root.left != null) {
                minD = Math.min(minDepth(root.left), minD);
            }
            if(root.right != null) {
                minD = Math.min(minDepth(root.right), minD);
            }
        }
        return minD + 1;
    }
}
