/**
 * 给你两个 稀疏矩阵 A 和 B，请你返回 AB 的结果。你可以默认 A 的列数等于 B 的行数。
 *
 * 请仔细阅读下面的示例。
 *
 * 示例：
 * 输入：
 * A = [
 *   [ 1, 0, 0],
 *   [-1, 0, 3]
 * ]
 * B = [
 *   [ 7, 0, 0 ],
 *   [ 0, 0, 0 ],
 *   [ 0, 0, 1 ]
 * ]
 * 输出：
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-matrix-multiplication
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0311 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int n = mat2[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < mat1.length; i++) {
            int[] r = new int[n];
            for (int k = 0; k < mat2[0].length; k++) {
                int a = 0;
                for (int j = 0; j < mat1[0].length; j++) {
                    a += mat1[i][j] * mat2[j][k];
                }
                r[k] = a;
            }
            result[i] = r;
        }
        return result;
    }
}
