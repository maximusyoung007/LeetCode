import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个电话目录管理系统，让它支持以下功能：
 *
 * get: 分配给用户一个未被使用的电话号码，获取失败请返回 -1
 * check: 检查指定的电话号码是否被使用
 * release: 释放掉一个电话号码，使其能够重新被分配
 *  
 * 示例：
 *
 * // 初始化电话目录，包括 3 个电话号码：0，1 和 2。
 * PhoneDirectory directory = new PhoneDirectory(3);
 *
 * // 可以返回任意未分配的号码，这里我们假设它返回 0。
 * directory.get();
 *
 * // 假设，函数返回 1。
 * directory.get();
 *
 * // 号码 2 未分配，所以返回为 true。
 * directory.check(2);
 *
 * // 返回 2，分配后，只剩一个号码未被分配。
 * directory.get();
 *
 * // 此时，号码 2 已经被分配，所以返回 false。
 * directory.check(2);
 *
 * // 释放号码 2，将该号码变回未分配状态。
 * directory.release(2);
 *
 * // 号码 2 现在是未分配状态，所以返回 true。
 * directory.check(2);
 *
 * 提示：
 *
 * 1 <= maxNumbers <= 10^4
 * 0 <= number < maxNumbers
 * 调用方法的总数处于区间 [0 - 20000] 之内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-phone-directory
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0379 {
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory(3);
        System.out.println(directory.get());
        System.out.println(directory.get());
        System.out.println(directory.check(2));
        System.out.println(directory.get());
        System.out.println(directory.check(2));
        directory.release(2);
        System.out.println(directory.check(2));
    }

}

class PhoneDirectory {
    List<Integer> numbers = new ArrayList<>();
    public PhoneDirectory(int maxNumbers) {
        for (int i = 0; i < maxNumbers; i++) {
            numbers.add(-1);
        }
    }

    public int get() {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == -1) {
                numbers.set(i, i);
                return numbers.get(i);
            }
        }
        return -1;
    }
    public boolean check(int number) {
        if (numbers.get(number) == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void release(int number) {
        numbers.set(number, -1);
    }
}
