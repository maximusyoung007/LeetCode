/**
 * 请设计并实现一个能够展开二维向量的迭代器。该迭代器需要支持 next 和 hasNext 两种操作。
 *
 *
 *
 * 示例：
 *
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 *
 * iterator.next(); // 返回 1
 * iterator.next(); // 返回 2
 * iterator.next(); // 返回 3
 * iterator.hasNext(); // 返回 true
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 4
 * iterator.hasNext(); // 返回 false
 *
 *
 *
 * 注意：
 *
 *    1、 请记得 重置 在 Vector2D 中声明的类变量（静态变量），因为类变量会 在多个测试用例中保持不变，影响判题准确。请 查阅 这里。
 *    2、 你可以假定 next() 的调用总是合法的，即当 next() 被调用时，二维向量总是存在至少一个后续元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-2d-vector
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0251 {
    public static void main(String[] args) {
        int[][] vec = new int[][]{{},{3}, {}, {}, {}};
        Vector2D obj = new Vector2D(vec);
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
//        int[][] vec2 = new int[][]{{1, 2}, {3}, {4}};
//        Vector2D obj = new Vector2D(vec2);
//        System.out.println(obj.next());
//        System.out.println(obj.next());
//        System.out.println(obj.next());
//        System.out.println(obj.hasNext());
//        System.out.println(obj.hasNext());
//        System.out.println(obj.next());
//        System.out.println(obj.hasNext());

    }
}

class Vector2D {
    int[][] vec;
    int inner;
    int outer;

    public Vector2D(int[][] vec) {
        this.vec = vec;
        this.inner = 0;
        this.outer = 0;
    }

    public boolean pointToInt(int inner, int out) {
        if (out < vec.length && inner < vec[out].length) {
            if (Math.round(this.vec[out][inner]) == this.vec[out][inner]) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int next() {
        while (this.outer < this.vec.length) {
            if (pointToInt(this.inner, this.outer)) {
                int inner = this.inner;
                int outer = this.outer;
                if (this.inner < this.vec[outer].length - 1) {
                    this.inner++;
                } else {
                    this.inner = 0;
                    this.outer++;
                }
                return this.vec[outer][inner];
            } else {
                if (this.inner < this.vec[outer].length - 1) {
                    this.inner++;
                } else {
                    this.inner = 0;
                    this.outer++;
                }
            }
        }
        return 0;
    }

    public boolean hasNext() {
        if (this.outer >= vec.length) {
            return false;
        } else if (this.outer == vec.length - 1) {
            if (this.inner >= vec[outer].length) {
                return false;
            }
        } else {
            int inner = this.inner;
            int out = this.outer;
            while (out < vec.length) {
                if (pointToInt(inner, out)) {
                    return true;
                } else {
                    if (this.inner < this.vec[out].length - 1) {
                        inner++;
                    } else {
                        inner = 0;
                        out++;
                    }
                }
            }
            if (out == vec.length) {
                return false;
            }
        }
        return true;
    }
}
