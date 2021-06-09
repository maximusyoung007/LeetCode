import java.util.*;

/**
 * 单词的 缩写 需要遵循 <起始字母><中间字母数><结尾字母> 这样的格式。如果单词只有两个字符，那么它就是它自身的 缩写 。
 *
 * 以下是一些单词缩写的范例：
 *
 *     dog --> d1g 因为第一个字母 'd' 和最后一个字母 'g' 之间有 1 个字母
 *     internationalization --> i18n 因为第一个字母 'i' 和最后一个字母 'n' 之间有 18 个字母
 *     it --> it 单词只有两个字符，它就是它自身的 缩写
 *
 * 实现 ValidWordAbbr 类：
 *
 *     ValidWordAbbr(String[] dictionary) 使用单词字典 dictionary 初始化对象
 *     boolean isUnique(string word) 如果满足下述任意一个条件，返回 true ；否则，返回 false ：
 *         字典 dictionary 中没有任何其他单词的 缩写 与该单词 word 的 缩写 相同。
 *         字典 dictionary 中的所有 缩写 与该单词 word 的 缩写 相同的单词都与 word 相同 。
 * 示例：
 *
 * 输入
 * ["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique"]
 * [[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"]]
 * 输出
 * [null, false, true, false, true]
 *
 * 解释
 * ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", "card"]);
 * validWordAbbr.isUnique("dear"); // 返回 false，字典中的 "deer" 与输入 "dear" 的缩写都是 "d2r"，但这两个单词不相同
 * validWordAbbr.isUnique("cart"); // 返回 true，字典中不存在缩写为 "c2t" 的单词
 * validWordAbbr.isUnique("cane"); // 返回 false，字典中的 "cake" 与输入 "cane" 的缩写都是 "c2e"，但这两个单词不相同
 * validWordAbbr.isUnique("make"); // 返回 true，字典中不存在缩写为 "m2e" 的单词
 * validWordAbbr.isUnique("cake"); // 返回 true，因为 "cake" 已经存在于字典中，并且字典中没有其他缩写为 "c2e" 的单词
 *
 *
 *
 * 提示：
 *
 *     1 <= dictionary.length <= 3 * 104
 *     1 <= dictionary[i].length <= 20
 *     dictionary[i] 由小写英文字母组成
 *     1 <= word <= 20
 *     word 由小写英文字母组成
 *     最多调用 5000 次 isUnique
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-word-abbreviation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0288 {
    public static void main(String[] args) {
        String[] dictionary = new String[]{"deer", "door", "cake", "card"};
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(dictionary);
        System.out.println(validWordAbbr.isUnique("dear"));
        System.out.println(validWordAbbr.isUnique("cart"));
        System.out.println(validWordAbbr.isUnique("cane"));
        System.out.println(validWordAbbr.isUnique("make"));
        System.out.println(validWordAbbr.isUnique("cake"));
//        String[] dictionary2 = new String[] {"a", "a"};
//        ValidWordAbbr validWordAbbr1 = new ValidWordAbbr(dictionary2);
//        System.out.println(validWordAbbr1.isUnique("a"));
    }
}

class ValidWordAbbr {
    Map<String, List<String>> m = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for (String t : dictionary) {
            String rt = getAbbreviations(t);
            List<String> rtList = new ArrayList<>();
            if (m.containsKey(rt)) {
                rtList = m.get(rt);
            }
            rtList.add(t);
            m.put(rt, rtList);
        }
    }

    public boolean isUnique(String word) {
        String rt = getAbbreviations(word);
        if (!m.containsKey(rt)) {
            return true;
        } else {
            List<String> list = m.get(rt);
            Set<String> set = new HashSet<>(list);
            if (set.size() > 1) {
                return false;
            }
            if (!list.get(0).equals(word)) {
                return false;
            }
        }
        return true;
    }

    public String getAbbreviations(String t) {
        if (t.length() <= 1) {
            return t;
        }
        char start = t.charAt(0);
        char end = t.charAt(t.length() - 1);
        String t2 = t.substring(1, t.length() - 1);
        String num = "";
        if (t2.length() > 0) {
            num = String.valueOf(t2.length());
        }
        String rt = start + num + end;
        return rt;
    }
}