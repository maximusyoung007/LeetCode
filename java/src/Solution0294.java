/**
 * 你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下：
 *
 * 给你一个字符串 currentState ，其中只含 '+' 和 '-' 。你和朋友轮流将 连续 的两个 "++" 反转成 "--" 。当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
 *
 * 请你写出一个函数来判定起始玩家 是否存在必胜的方案 ：如果存在，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：currentState = "++++"
 * 输出：true
 * 解释：起始玩家可将中间的 "++" 翻转变为 "+--+" 从而得胜。
 * 示例 2：
 *
 * 输入：currentState = "+"
 * 输出：false
 *  
 * 提示：
 * 1 <= currentState.length <= 60
 * currentState[i] 不是 '+' 就是 '-'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0294 {
    public boolean canWin(String currentState) {
        if (currentState.length() == 1) {
            return false;
        }
        StringBuilder currentState1 = new StringBuilder(currentState);
        return canWin1(currentState1);
    }

    public boolean canWin1(StringBuilder currentState) {
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == currentState.charAt(i + 1) && currentState.charAt(i) == '+') {
                currentState.replace(i, i + 2, "--");
                //下一个人要输了，我就赢了
                if (!canWin1(currentState)) {
                    currentState.replace(i, i + 2, "++");
                    return true;
                }
                currentState.replace(i, i + 2, "++");
            }
        }
        return false;
    }
}
