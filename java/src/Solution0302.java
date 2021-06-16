/**
 * 图片在计算机处理中往往是使用二维矩阵来表示的。
 *
 * 假设，这里我们用的是一张黑白的图片，那么 0 代表白色像素，1 代表黑色像素。
 *
 * 其中黑色的像素他们相互连接，也就是说，图片中只会有一片连在一块儿的黑色像素（像素点是水平或竖直方向连接的）。
 *
 * 那么，给出某一个黑色像素点 (x, y) 的位置，你是否可以找出包含全部黑色像素的最小矩形（与坐标轴对齐）的面积呢？
 *
 *
 *
 * 示例:
 *
 * 输入:
 * [
 *   "0010",
 *   "0110",
 *   "0100"
 * ]
 * 和 x = 0, y = 2
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-rectangle-enclosing-black-pixels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0302 {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = findLeft(image, 0, y, 0, m);
        int right = findRight(image, y + 1, n, 0, m);
        int top = findTop(image, 0, x, 0, n);
        int bottom = findBottom(image, x + 1, m, 0, n);
        return (bottom - top) * (right - left);
    }

    private int findLeft(char[][] image, int i, int j, int top, int bottom) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') {
                k++;
            }
            //有黑块
            if (k < bottom) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }

    private int findRight(char[][] image, int i, int j, int top, int bottom) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') {
                k++;
            }
            //有黑块
            if (k < bottom) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    private int findTop(char[][] image, int i, int j, int left, int right) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') {
                k++;
            }
            if (k < right) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    private int findBottom(char[][] image, int i, int j, int left, int right) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') {
                k++;
            }
            if (k < right) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}
