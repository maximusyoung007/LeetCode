import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你设计一个 贪吃蛇游戏，该游戏将会在一个 屏幕尺寸 = 宽度 x 高度 的屏幕上运行。如果你不熟悉这个游戏，可以 点击这里 在线试玩。
 *
 * 起初时，蛇在左上角的 (0, 0) 位置，身体长度为 1 个单位。
 *
 * 你将会被给出一个数组形式的食物位置序列 food ，其中 food[i] = (ri, ci) 。当蛇吃到食物时，身子的长度会增加 1 个单位，得分也会 +1 。
 *
 * 食物不会同时出现，会按列表的顺序逐一显示在屏幕上。比方讲，第一个食物被蛇吃掉后，第二个食物才会出现。
 *
 * 当一个食物在屏幕上出现时，保证 不会 出现在被蛇身体占据的格子里。
 *
 * 如果蛇越界（与边界相撞）或者头与 移动后 的身体相撞（即，身长为 4 的蛇无法与自己相撞），游戏结束。
 *
 * 实现 SnakeGame 类：
 *
 * SnakeGame(int width, int height, int[][] food) 初始化对象，屏幕大小为 height x width ，食物位置序列为 food
 * int move(String direction) 返回蛇在方向 direction 上移动后的得分。如果游戏结束，返回 -1 。
 *  
 * 示例 1：
 * 输入：
 * ["SnakeGame", "move", "move", "move", "move", "move", "move"]
 * [[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]
 * 输出：
 * [null, 0, 0, 1, 1, 2, -1]
 *
 * 解释：
 * SnakeGame snakeGame = new SnakeGame(3, 2, [[1, 2], [0, 1]]);
 * snakeGame.move("R"); // 返回 0
 * snakeGame.move("D"); // 返回 0
 * snakeGame.move("R"); // 返回 1 ，蛇吃掉了第一个食物，同时第二个食物出现在 (0, 1)
 * snakeGame.move("U"); // 返回 1
 * snakeGame.move("L"); // 返回 2 ，蛇吃掉了第二个食物，没有出现更多食物
 * snakeGame.move("U"); // 返回 -1 ，蛇与边界相撞，游戏结束
 *  
 * 提示：
 *
 * 1 <= width, height <= 104
 * 1 <= food.length <= 50
 * food[i].length == 2
 * 0 <= ri < height
 * 0 <= ci < width
 * direction.length == 1
 * direction is 'U', 'D', 'L', or 'R'.
 * 最多调用 104 次 move 方法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-snake-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0353 {
    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(3, 2, new int[][] {{1, 2}, {0, 1}});
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("U"));
//        SnakeGame snakeGame = new SnakeGame(2, 2, new int[][] {{0, 1}});
//        System.out.println(snakeGame.move("R"));
//        System.out.println(snakeGame.move("D"));
//        SnakeGame snakeGame = new SnakeGame(2, 2, new int[][] {{1, 0}});
//        System.out.println(snakeGame.move("R"));
//        System.out.println(snakeGame.move("D"));
//        System.out.println(snakeGame.move("L"));
//        System.out.println(snakeGame.move("U"));
//        System.out.println(snakeGame.move("R"));
    }
}
class SnakeGame {
    //一个队列保存已经变成蛇的
    Deque<int[]> snake = new LinkedList();
    //第几个food
    int count = 0;
    int width = 0, height = 0;
    int[][] food;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        snake.add(new int[] {0, 0});
        this.width = width;
        this.height = height;
        this.food = food;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = snake.getFirst();
        //nextHead
        int[] nextHead = new int[1];
        if (direction.equals("U")) {
            nextHead = new int[] {head[0] - 1, head[1]};
        }
        if (direction.equals("L")) {
            nextHead = new int[] {head[0], head[1] - 1};
        }
        if (direction.equals("R")) {
            nextHead = new int[] {head[0], head[1] + 1};
        }
        if (direction.equals("D")) {
            nextHead = new int[] {head[0] + 1, head[1]};
        }
        //越界
        if (nextHead[0] < 0 || nextHead[0] >= height || nextHead[1] < 0 || nextHead[1] >= width) {
            return -1;
        }
        int[] f = new int[] {-1, -1};
        if (count <= food.length - 1) {
            f = food[count];
            if (f[0] < 0 || f[0] >= height || f[1] < 0 || f[1] >= width) {
                return -1;
            }
        }
        //吃到食物了，加头
        if (nextHead[0] == f[0] && nextHead[1] == f[1]) {
            snake.addFirst(nextHead);
            count++;
        }
        //没有吃到食物，去尾加头，判断头是否和自己相撞
        else {
            snake.removeLast();
            Deque<int[]> st = new LinkedList<>();
            st.addAll(snake);
            while (!st.isEmpty()) {
                int[] t = st.getFirst();
                //撞到自己了
                if (nextHead[0] == t[0] && nextHead[1] == t[1]) {
                    return -1;
                }
                st.removeFirst();
            }
            snake.addFirst(nextHead);
        }
        return snake.size() - 1;
    }
}