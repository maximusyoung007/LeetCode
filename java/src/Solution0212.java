import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Example 1:
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],
 * ["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 *
 * Example 2:
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []

 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0212 {
    int[][] nextMove = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        if (board.length <= 0 || words.length <= 0) {
            return result;
        }
        int m = board.length, n = board[0].length;
        for (int k = 0; k < words.length; k++) {
            int[][] visited = new int[m][n];
            List<int[]> start = new ArrayList<>();
            int x = -1, y = -1;
            String word = words[k];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        int[] t = new int[] {i, j};
                        start.add(t);
                    }
                }
            }
            if (start.size() == 0) {
                continue;
            }
            for (int i = 0; i < start.size(); i++) {
                x = start.get(i)[0];
                y = start.get(i)[1];
                if (bfs(board, word, x, y, 0, visited)) {
                    set.add(word);
                }
            }
        }
        result.addAll(set);
        return result;
    }

    boolean bfs(char[][] board, String word, int x, int y, int num, int[][] visited) {
        if (x == -1 || y == -1) {
            return false;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        //如果这个节点访问过了，不能重复访问
        if (visited[x][y] == 1) {
            return false;
        } else {
            visited[x][y] = 1;
        }

        if (word.charAt(num) != board[x][y]) {
            visited[x][y] = 0;
            return false;
        } else {
            if (num == word.length() - 1) {
                return true;
            }
        }
        for (int i = 0; i < nextMove.length; i++) {
            int nextX  = x + nextMove[i][0];
            int nextY = y + nextMove[i][1];
            boolean r = bfs(board, word, nextX, nextY, num + 1, visited);
            if (!r) {
                continue;
            } else {
                return r;
            }
        }
        visited[x][y] = 0;
        return false;
    }

}
