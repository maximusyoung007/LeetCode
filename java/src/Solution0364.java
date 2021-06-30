import java.util.List;

/**
 * 给一个嵌套整数序列，请你返回每个数字在序列中的加权和，它们的权重由它们的深度决定。
 *
 * 序列中的每一个元素要么是一个整数，要么是一个序列（这个序列中的每个元素也同样是整数或序列）。
 *
 * 与 前一个问题 不同的是，前一题的权重按照从根到叶逐一增加，而本题的权重从叶到根逐一增加。
 *
 * 也就是说，在本题中，叶子的权重为1，而根拥有最大的权重。
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: 8
 * 解释: 四个 1 在深度为 1 的位置， 一个 2 在深度为 2 的位置。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: 17
 * 解释: 一个 1 在深度为 3 的位置， 一个 4 在深度为 2 的位置，一个 6 在深度为 1 的位置。 1*3 + 4*2 + 6*1 = 17。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nested-list-weight-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0364 {
    int depth = 0, maxDepth = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        //先求出最大深度
        depthSum(nestedList);
        return depthSumReverse(nestedList, maxDepth);
    }

    public void depthSum (List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            if (!n.isInteger()) {
                depth++;
                if (depth > maxDepth) {
                    maxDepth = depth;
                }
                depthSum(n.getList());
                //回到上一层后，深度也要回到上一层的深度
                depth--;
            }
        }
    }

    public int depthSumReverse(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += depthSumReverse(n.getList(), depth - 1);
            }
        }
        return sum;
    }
}
