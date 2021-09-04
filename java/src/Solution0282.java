import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 *
 * 示例 1:
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"]
 *
 * 示例 2:
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 *
 * 示例 3:
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]

 * 示例 4:
 *
 * 输入: num = "00", target = 0
 * 输出: ["0+0", "0-0", "0*0"]
 *
 * 示例 5:
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 *  
 * 提示：
 * 0 <= num.length <= 10
 * num 仅含数字
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/expression-add-operators
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0282 {
    public List<String> addOperators(String num, int target) {
        List<List<String>> result = new ArrayList<>();
        List<String> partResult = new ArrayList<>();
        List<String> r = new ArrayList<>();
        for (int j = 1; j <= num.length(); j++) {
            String sc = num.substring(0, j);
            if (sc.length() > 1 && sc.charAt(0) == '0') {
                continue;
            }
            partResult.add(sc);
            long ic = Long.parseLong(sc);
            dfs(result, partResult, j, num, target, ic);
            partResult.remove(partResult.size() - 1);
        }
        for (List<String> pr : result) {
            StringBuilder sb = new StringBuilder("");
            for (String s : pr) {
                sb.append(s);
            }
            r.add(sb.toString());
        }
        return r;
    }

    public void dfs (List<List<String>> result, List<String> partResult, int index, String num, int target, Long computed) {
        if (computed == target && index == num.length()) {
            List<String> addList = new ArrayList<>();
            for (String s : partResult) {
                addList.add(s);
            }
            result.add(addList);
            return;
        }
        if (index >= num.length()) {
            return;
        }

        for (int i = 1; i + index <= num.length(); i++) {
            String sc = num.substring(index, index + i);
            if (sc.length() > 1 && sc.charAt(0) == '0') {
                continue;
            }
            int ic = Integer.parseInt(sc);

            //加号
            long nextComputed = computed + ic;
            partResult.add("+");
            partResult.add(sc);
            dfs(result, partResult, index + i, num, target, nextComputed);
            partResult.remove(partResult.size() - 1);
            partResult.remove(partResult.size() - 1);

            //减号
            nextComputed = computed - ic;
            partResult.add("-");
            partResult.add(sc);
            dfs(result, partResult, index + i, num, target, nextComputed);
            partResult.remove(partResult.size() - 1);
            partResult.remove(partResult.size() - 1);
            //乘号
            if (partResult.size() >= 3) {
                int preNum = Integer.parseInt(partResult.get(partResult.size() - 1));
                if (partResult.size() - 2 >= 0 && partResult.get(partResult.size() - 2).equals("-")) {
                    nextComputed = computed + preNum - preNum * ic;
                    partResult.add("*");
                    partResult.add(sc);
                    dfs(result, partResult, index + i, num, target, nextComputed);
                    partResult.remove(partResult.size() - 1);
                    partResult.remove(partResult.size() - 1);
                } else if (partResult.size() - 2 >= 0 && partResult.get(partResult.size() - 2).equals("+")) {
                    nextComputed = computed - preNum + preNum * ic;
                    partResult.add("*");
                    partResult.add(sc);
                    dfs(result, partResult, index + i, num, target, nextComputed);
                    partResult.remove(partResult.size() - 1);
                    partResult.remove(partResult.size() - 1);
                } else if (partResult.size() - 2 >= 0 && partResult.get(partResult.size() - 2).equals("*")) {
                    int times = 1;
                    int product = Integer.parseInt(partResult.get(partResult.size() - 1));
                    while (partResult.size() - 2 * times >= 0 && partResult.get(partResult.size() - 2 * times).equals("*")) {
                        int factor2 = Integer.parseInt(partResult.get(partResult.size() - 2 * times - 1));
                        product *= factor2;
                        times++;
                    }
                    if (partResult.size() - 2 * times > 0 && partResult.get(partResult.size() - 2 * times).equals("+")) {
                        nextComputed = computed - product + product * ic;
                        partResult.add("*");
                        partResult.add(sc);
                        dfs(result, partResult, index + i, num, target, nextComputed);
                        partResult.remove(partResult.size() - 1);
                        partResult.remove(partResult.size() - 1);
                    } else if (partResult.size() - 2 * times > 0 && partResult.get(partResult.size() - 2 * times).equals("-")) {
                        nextComputed = computed + product - product * ic;
                        partResult.add("*");
                        partResult.add(sc);
                        dfs(result, partResult, index + i, num, target, nextComputed);
                        partResult.remove(partResult.size() - 1);
                        partResult.remove(partResult.size() - 1);
                    } else if (partResult.size() - 2 * times <= 0) {
                        nextComputed = product * ic;
                        partResult.add("*");
                        partResult.add(sc);
                        dfs(result, partResult, index + i, num, target, nextComputed);
                        partResult.remove(partResult.size() - 1);
                        partResult.remove(partResult.size() - 1);
                    }
                }
            } else {
                int factor1 = Integer.parseInt(partResult.get(0));
                nextComputed = factor1 * ic;
                partResult.add("*");
                partResult.add(sc);
                dfs(result, partResult, index + i, num, target, nextComputed);
                partResult.remove(partResult.size() - 1);
                partResult.remove(partResult.size() - 1);
            }

        }
    }
}
