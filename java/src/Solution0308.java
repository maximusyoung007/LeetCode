/**
 * 给你一个 2D 矩阵 matrix，请计算出从左上角 (row1, col1) 到右下角 (row2, col2) 组成的矩形中所有元素的和。
 *
 * 上述粉色矩形框内的，该矩形由左上角 (row1, col1) = (2, 1) 和右下角 (row2, col2) = (4, 3) 确定。其中，所包括的元素总和 sum = 8。
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 *  
 * 注意:
 *
 * 矩阵 matrix 的值只能通过 update 函数来进行修改
 * 你可以默认 update 函数和 sumRegion 函数的调用次数是均匀分布的
 * 你可以默认 row1 ≤ row2，col1 ≤ col2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0308 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix2 numMatrix2 = new NumMatrix2(matrix);
        System.out.println(numMatrix2.sumRegion(2, 1, 4, 3));
        numMatrix2.update(3, 2, 2);
        System.out.println(numMatrix2.sumRegion(2, 1, 4, 3));
//        int[][] matrix2 = new int[][] {
//                {2, 4},
//                {-3, 5}
//        };
//        NumMatrix2 numMatrix2 = new NumMatrix2(matrix2);
//        numMatrix2.update(0, 1, 3);
//        numMatrix2.update(1, 1, -3);
//        numMatrix2.update(0, 1, 1);
//        System.out.println(numMatrix2.sumRegion(0, 0, 1, 1));
    }
}

class NumMatrix2 {
    int[][] sums;
    int[][] matrix2;
    public NumMatrix2(int[][] matrix) {
        matrix2 = matrix;
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                sums[i][0] = 0;
            }
            for (int j = 0; j < n; j++) {
                sums[0][j] = 0;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public void update(int row, int col, int val) {
        int m = sums.length;
        int n = sums[0].length;
        int t = matrix2[row][col];
        int sub = val - t;
        matrix2[row][col] = val;
        //row,col改变，从row+1,col+1开始前缀和开始改变
        for (int i = row + 1; i < m; i++) {
            for (int j = col + 1; j < n; j++) {
                sums[i][j] = sums[i][j] + sub;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
    }
}
