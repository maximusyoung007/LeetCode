import java.util.List;

/**
 *给定一个嵌套的整数列表 nestedList ，每个元素要么是整数，要么是列表。同时，列表中元素同样也可以是整数或者是另一个列表。
 *
 * 整数的 深度 是其在列表内部的嵌套层数。例如，嵌套列表 [1,[2,2],[[3],2],1] 中每个整数的值就是其深度。
 *
 * 请返回该列表按深度加权后所有整数的总和。
 *
 * 示例 1：
 *
 * 输入：nestedList = [[1,1],2,[1,1]]
 * 输出：10
 * 解释：因为列表中有四个深度为 2 的 1 ，和一个深度为 1 的 2。
 * 示例 2：
 *
 * 输入：nestedList = [1,[4,[6]]]
 * 输出：27
 * 解释：一个深度为 1 的 1，一个深度为 2 的 4，一个深度为 3 的 6。所以，1 + 4*2 + 6*3 = 27。
 * 示例 3：
 *
 * 输入：nestedList = [0]
 * 输出：0
 *
 * 提示：
 *
 * 1 <= nestedList.length <= 50
 * 嵌套列表中整数的值在范围 [-100, 100] 内
 * 任何整数的最大 深度 都小于或等于 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nested-list-weight-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0339 {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += depthSum(n.getList(), depth + 1);
            }
        }
        return sum;
    }
}
