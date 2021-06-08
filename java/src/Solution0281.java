import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。
 *
 * 示例:
 *
 * 输入:
 * v1 = [1,2]
 * v2 = [3,4,5,6]
 *
 * 输出: [1,3,2,4,5,6]
 *
 * 解析: 通过连续调用 next 函数直到 hasNext 函数返回 false，
 *      next 函数返回值的次序应依次为: [1,3,2,4,5,6]。
 * 拓展：假如给你 k 个一维向量呢？你的代码在这种情况下的扩展性又会如何呢?
 *
 * 拓展声明：
 *  “锯齿” 顺序对于 k > 2 的情况定义可能会有些歧义。所以，假如你觉得 “锯齿” 这个表述不妥，也可以认为这是一种 “循环”。例如：
 *
 * 输入:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 *
 * 输出: [1,4,8,2,5,9,3,6,7].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0281 {
    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 2);
        List<Integer> v2 = Arrays.asList(3, 4, 5, 6);
        ZigzagIterator zig = new ZigzagIterator(v1, v2);
        while (zig.hasNext()) {
            System.out.println(zig.next());
        }
    }
}

class ZigzagIterator {
    List<Integer> list = new ArrayList<>();
    int index = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int index1 = 0, index2 = 0;
        while (index1 != v1.size() || index2 != v2.size()) {
            if (index1 < v1.size()) {
                list.add(v1.get(index1));
                index1++;
            }
            if (index2 < v2.size()) {
                list.add(v2.get(index2));
                index2++;
            }
        }
    }

    public int next() {
        int t = index;
        index++;
        return list.get(t);
    }

    public boolean hasNext() {
        return index < list.size();
    }
}
