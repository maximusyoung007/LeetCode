import java.util.ArrayList;
import java.util.List;

/**
 * 将非负整数 num 转换为其对应的英文表示。
 *
 * 示例 1：
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"

 * 示例 2：
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"

 * 示例 3：
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

 * 示例 4：
 * 输入：num = 1234567891
 * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *  
 * 提示：
 * 0 <= num <= 231 - 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-english-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0273 {
    public String numberToWords(int num) {
        StringBuilder res = new StringBuilder("");
        Integer n = new Integer(num);
        String ns = n.toString();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(ns);
        while (sb.length() >= 3) {
            list.add(sb.substring(sb.length() - 3, sb.length()));
            sb.replace(sb.length() - 3, sb.length(), "");
        }
        if (sb.length() >= 1) {
            list.add(sb.toString());
        }
        if (list.size() == 4) {
            List<String> l1 = threeWords(list.get(3));
            List<String> l2 = threeWords(list.get(2));
            List<String> l3 = threeWords(list.get(1));
            List<String> l4 = threeWords(list.get(0));
            if (l1.size() > 0) {
                for (String s : l1) {
                    res.append(s + " ");
                }
                res.append("Billion ");
            }
            if (l2.size() > 0) {
                for (String s : l2) {
                    res.append(s + " ");
                }
                res.append("Million ");
            }
            if (l3.size() > 0) {
                for (String s : l3) {
                    res.append(s + " ");
                }
                res.append("Thousand ");
            }
            if (l4.size() > 0) {
                for (String s : l4) {
                    res.append(s + " ");
                }
            }
        } else if (list.size() == 3) {
            List<String> l2 = threeWords(list.get(2));
            List<String> l3 = threeWords(list.get(1));
            List<String> l4 = threeWords(list.get(0));
            if (l2.size() > 0) {
                for (String s : l2) {
                    res.append(s + " ");
                }
                res.append("Million ");
            }
            if (l3.size() > 0) {
                for (String s : l3) {
                    res.append(s + " ");
                }
                res.append("Thousand ");
            }
            if (l4.size() > 0) {
                for (String s : l4) {
                    res.append(s + " ");
                }
            }
        } else if (list.size() == 2) {
            List<String> l3 = threeWords(list.get(1));
            List<String> l4 = threeWords(list.get(0));
            if (l3.size() > 0) {
                for (String s : l3) {
                    res.append(s + " ");
                }
                res.append("Thousand ");
            }
            if (l4.size() > 0) {
                for (String s : l4) {
                    res.append(s + " ");
                }
            }
        } else {
            List<String> l4 = threeWords(list.get(0));
            if (l4.size() > 0) {
                for (String s : l4) {
                    res.append(s + " ");
                }
            }
        }
        return res.toString().trim();
    }

    public List<String> threeWords(String num) {
        if (num.length() == 1) {
            if (num.equals("0")) {
                return new ArrayList() {{
                    add("Zero");
                }};
            } else if (num.equals("1")) {
                return new ArrayList() {{
                    add("One");
                }};
            } else if (num.equals("2")) {
                return new ArrayList() {{
                    add("Two");
                }};
            } else if (num.equals("3")) {
                return new ArrayList() {{
                    add("Three");
                }};
            } else if (num.equals("4")) {
                return new ArrayList() {{
                    add("Four");
                }};
            } else if (num.equals("5")) {
                return new ArrayList() {{
                    add("Five");
                }};
            } else if (num.equals("6")) {
                return new ArrayList() {{
                    add("Six");
                }};
            } else if (num.equals("7")) {
                return new ArrayList() {{
                    add("Seven");
                }};
            } else if (num.equals("8")) {
                return new ArrayList() {{
                    add("Eight");
                }};
            } else if (num.equals("9")) {
                return new ArrayList() {{
                    add("Nine");
                }};
            }
        }
        StringBuilder sb = new StringBuilder("");
        List<String> r = new ArrayList<>();
        int n1 = 0, n2 = 0, n3 = 0;
        if (num.length() == 3) {
            n1 = num.charAt(0) - '0';
            n2 = num.charAt(1) - '0';
            n3 = num.charAt(2) - '0';
        }
        if (num.length() == 2) {
            int n = Integer.parseInt(num);
            n3 = n % 10;
            n /= 10;
            n2 = n % 10;
        }
        if (n1 != 0) {
            switch (n1) {
                case 1:
                    r.add("One");
                    break;
                case 2:
                    r.add("Two");
                    break;
                case 3:
                    r.add("Three");
                    break;
                case 4:
                    r.add("Four");
                    break;
                case 5:
                    r.add("Five");
                    break;
                case 6:
                    r.add("Six");
                    break;
                case 7:
                    r.add("Seven");
                    break;
                case 8:
                    r.add("Eight");
                    break;
                case 9:
                    r.add("Nine");
                    break;
            }
            r.add("Hundred");
        }
        if (n2 != 0) {
            if (n2 != 1) {
                switch (n2) {
                    case 2:
                        r.add("Twenty");
                        break;
                    case 3:
                        r.add("Thirty");
                        break;
                    case 4:
                        r.add("Forty");
                        break;
                    case 5:
                        r.add("Fifty");
                        break;
                    case 6:
                        r.add("Sixty");
                        break;
                    case 7:
                        r.add("Seventy");
                        break;
                    case 8:
                        r.add("Eighty");
                        break;
                    case 9:
                        r.add("Ninety");
                        break;
                }
            } else if (n2 == 1){
                switch (n3) {
                    case 0:
                        r.add("Ten");
                        break;
                    case 1:
                        r.add("Eleven");
                        break;
                    case 2:
                        r.add("Twelve");
                        break;
                    case 3:
                        r.add("Thirteen");
                        break;
                    case 4:
                        r.add("Fourteen");
                        break;
                    case 5:
                        r.add("Fifteen");
                        break;
                    case 6:
                        r.add("Sixteen");
                        break;
                    case 7:
                        r.add("Seventeen");
                        break;
                    case 8:
                        r.add("Eighteen");
                        break;
                    case 9:
                        r.add("Nineteen");
                        break;
                }
                return r;
            }
        }

        if (n3 != 0) {
            sb.append(" ");
            switch (n3) {
                case 1:
                    r.add("One");
                    break;
                case 2:
                    r.add("Two");
                    break;
                case 3:
                    r.add("Three");
                    break;
                case 4:
                    r.add("Four");
                    break;
                case 5:
                    r.add("Five");
                    break;
                case 6:
                    r.add("Six");
                    break;
                case 7:
                    r.add("Seven");
                    break;
                case 8:
                    r.add("Eight");
                    break;
                case 9:
                    r.add("Nine");
                    break;
            }
        }
        return r;
    }
}
