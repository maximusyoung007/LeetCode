import java.util.Stack;

/**
 * 给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
 * 你可以假定该序列中的数都是不相同的。
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 示例 1：
 * 输入: [5,2,6,1,3]
 * 输出: false
 *
 * 示例 2：
 * 输入: [5,2,1,3,6]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0255 {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int i : preorder) {
            if (i < min) {
                return false;
            }
            while (stack.size() > 0 && i > stack.peek()) {
                min = stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return true;
    }

    /**
     * 递归超时，不能保证正确性
     */
//    public boolean isBST(int[] preorder, int start, int end) {
//        if (start >= end) {
//            return true;
//        }
//        int i;
//        for (i = start; i < end; i++) {
//            if (preorder[i] > preorder[start]) {
//                break;
//            }
//        }
//        for (int j = i; j < end; j++) {
//            if (preorder[j] < preorder[start]) {
//                return false;
//            }
//        }
//        return isBST(preorder, start, i - 1) && isBST(preorder, i, end) && isBST(preorder, start + 1, end);
//    }
}
