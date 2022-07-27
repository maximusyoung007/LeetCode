import java.util.ArrayList;
import java.util.List;

public class Solution0592 {
	public String fractionAddition(String expression) {
		List<String[]> es= new ArrayList<>();
		int lcm = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '/') {
				String s = "";
				if (es.size() == 0) {
					lcm = 1;
				}
				int j = 0;
				for (j = i - 1; j >= 0; j--) {
					if (expression.charAt(j) > '9' || expression.charAt(j) < '0') {
						if (expression.charAt(j) == '-') {
							s = "-";
						} else {
							s = "+";
						}
						break;
					}
				}
				if (j == -1) {
					s = "+";
				}
				String pre = expression.substring(j + 1, i);
				for (j = i + 1; j < expression.length(); j++) {
					if (expression.charAt(j) > '9' || expression.charAt(j) < '0') {
						break;
					}
				}
				String next = expression.substring(i+1, j);
				String[] strs = {s, pre, next};
				lcm = lcm(lcm, Integer.parseInt(next));
				es.add(strs);
			}
		}
		int num = 0;
		for (String[] s : es) {
			int i = Integer.parseInt(s[1]) * (lcm / Integer.parseInt(s[2]));
			if (s[0].equals("+")) {
				num += i;
			} else {
				num -= i;
			}
		}
		int z = measure(num, lcm);
		num /= z;
		lcm /= z;
		if (num == 0) {
			return num + "/1";
		} else {
			if (num * lcm > 0) {
				return num + "/" + lcm;
			} else {
				return "-" + Math.abs(num) + "/" + Math.abs(lcm);
			}
		}
	}

	private int lcm(int m, int n) {
		if (m > n) {
			int t = m;
			m = n;
			n = t;
		}
		for (int i = m; i < n * m; i++) {
			if (i % m == 0 && i % n == 0) {
				return i;
			}
		}
		return n * m;
	}

	private int measure(int x, int y) {
		int z = y;
		while (x % y != 0) {
			z = x % y;
			x = y;
			y = z;
		}
		return z;
	}
}
