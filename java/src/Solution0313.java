import java.util.ArrayList;
import java.util.List;

/**
 *超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 *
 * 示例 1：
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。

 * 示例 2：
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 *  
 * 提示：
 * 1 <= n <= 106
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据 保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0313 {
    //从264改进过来，264从最小的数乘2， 3， 5，本题从最小的数乘primes中的各数
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int i = 2;
        int len = primes.length;
        int[] index = new int[len];
        for (int j = 0; j < index.length; j++) {
            index[j] = 1;
        }
        while (dp[n] == 0) {
            int min = Integer.MAX_VALUE, minJ = 0;
            List<Integer> minTemp = new ArrayList<>();
            for (int j = 0; j < index.length; j++) {
                if (dp[index[j]] * primes[j] <= min) {
                    //记录最小的值和下标,下标最小的向前进1
                    if (dp[index[j]] * primes[j] < min) {
                        min = dp[index[j]] * primes[j];
                        minTemp.clear();
                    }
                    min = dp[index[j]] * primes[j];
                    minTemp.add(j);
                }
            }
            dp[i] = min;
            //有重复的，两个index同步+1
            for (Integer ti : minTemp) {
                index[ti]++;
            }
            i++;
        }
        return dp[n];
    }
}
