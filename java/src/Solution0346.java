import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
 *
 * 实现 MovingAverage 类：
 *
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 计算并返回数据流中最后 size 个值的移动平均值。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 *
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 1
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 *  
 * 提示：
 *
 * 1 <= size <= 1000
 * -105 <= val <= 105
 * 最多调用 next 方法 104 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/moving-average-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0346 {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}

class MovingAverage {
    int size = 0;
    Queue<Double> queue = new LinkedList<>();
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        queue.add((double) val);
        while (queue.size() > size) {
            queue.poll();
        }
        int sum = 0;
        for (double d : queue) {
            sum += d;
        }
        double result = (double)sum / (double)queue.size();
        return result;
    }
}
