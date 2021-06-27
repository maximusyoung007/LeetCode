import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。用户可以设置一个 “解锁模式” ，
 * 通过连接特定序列中的点，形成一系列彼此连接的线段，每个线段的端点都是序列中两个连续的点。如果满足以下两个条件，则 k 点序列是有效的解锁模式：
 *
 * 解锁模式中的所有点 互不相同 。
 * 假如模式中两个连续点的线段需要经过其他点，那么要经过的点必须事先出现在序列中（已经经过），不能跨过任何还未被经过的点。
 *  
 * 以下是一些有效和无效解锁模式的示例：
 * 无效手势：[4,1,3,6] ，连接点 1 和点 3 时经过了未被连接过的 2 号点。
 * 无效手势：[4,1,9,2] ，连接点 1 和点 9 时经过了未被连接过的 5 号点。
 * 有效手势：[2,4,1,3,6] ，连接点 1 和点 3 是有效的，因为虽然它经过了点 2 ，但是点 2 在该手势中之前已经被连过了。
 * 有效手势：[6,5,4,1,9,2] ，连接点 1 和点 9 是有效的，因为虽然它经过了按键 5 ，但是点 5 在该手势中之前已经被连过了。
 * 给你两个整数，分别为 ​​m 和 n ，那么请你统计一下有多少种 不同且有效的解锁模式 ，是 至少 需要经过 m 个点，但是 不超过 n 个点的。
 *
 * 两个解锁模式 不同 需满足：经过的点不同或者经过点的顺序不同。
 *
 * 示例 1：
 * 输入：m = 1, n = 1
 * 输出：9
 *
 * 示例 2：
 * 输入：m = 1, n = 2
 * 输出：65
 *  
 * 提示：
 *
 * 1 <= m, n <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/android-unlock-patterns
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0351 {
    int count = 0;
    List<String> t = new ArrayList<>();
    Map<Integer, int[]> pointIndex = new HashMap() {{
        put(1, new int[] {0, 0});
        put(2, new int[] {0, 1});
        put(3, new int[] {0, 2});
        put(4, new int[] {1, 0});
        put(5, new int[] {1, 1});
        put(6, new int[] {1, 2});
        put(7, new int[] {2, 0});
        put(8, new int[] {2, 1});
        put(9, new int[] {2, 2});
    }};
    public int numberOfPatterns(int m, int n) {
        String s = "";
        for (int i = m; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                numberOfPatterns(j, s, i);
            }
        }
        t.stream().sorted();
        return count;
    }

    public void numberOfPatterns(int i, String s, int len) {
        if (s.length() > 0) {
            int a = Integer.parseInt(s.substring(s.length() - 1));
            int[] index = pointIndex.get(a);
            int[] index2 = pointIndex.get(i);
            //判断i和a是否不相邻,判断i和a之间的数是否访问过，没有访问过手势就是错的
            if (!judge(index, index2)) {
                //在同一行
                if (index[0] == index2[0]) {
                    if (i > a) {
                        Integer j;
                        for (j = a + 1; j < i; j++) {
                            if (s.indexOf(j.toString()) == -1) {
                                return;
                            }
                        }
                    } else {
                        Integer j;
                        for (j = a - 1; j > i; j--) {
                            if (s.indexOf(j.toString()) == -1) {
                                return;
                            }
                        }
                    }
                }
                //在同一列
                else if (index[1] == index2[1]) {
                    if (i > a) {
                        Integer j;
                        for (j = a + 3; j < i; j += 3) {
                            if (s.indexOf(j.toString()) == -1) {
                                return;
                            }
                        }
                    } else {
                        Integer j;
                        for (j = a - 3; j > i; j -= 3) {
                            if (s.indexOf(j.toString()) == -1) {
                                return;
                            }
                        }
                    }
                }
                else if ((a == 1 && i == 9) || (a == 9 && i == 1) || (a == 7 && i == 3) || (a == 3 && i == 7)) {
                    if (s.indexOf('5') == -1) {
                        return;
                    }
                }
            }
        }

        s = s + i;
        if (s.length() == len) {
            t.add(s);
            count++;
            return;
        }
        for (Integer j = 1; j <= 9; j++) {
            //j中存在,就跳过
            if (s.length() > 0) {
                if (s.indexOf(j.toString()) != -1) {
                    continue;
                } else {
                    numberOfPatterns(j, s, len);
                }
            } else {
                numberOfPatterns(j, s, len);
            }
        }
    }

    boolean judge(int[] index1 , int[] index2) {
        int[][] move = new int[][] {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1},
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1},
                {2, 1},
                {2, -1},
                {-2, 1},
                {-2, -1},
                {1, 2},
                {1, -2},
                {-1, -2},
                {-1, 2},
        };
        for (int i = 0; i < move.length; i++) {
            //能走到相邻的点
            if (index2[0] == (index1[0] + move[i][0]) && index2[1] == (index1[1] + move[i][1])) {
                return true;
            }
        }
        return false;
    }
}
