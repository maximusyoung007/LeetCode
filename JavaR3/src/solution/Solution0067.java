package solution;

public class Solution0067 {
	public String addBinary(String a, String b) {
		int n1 = a.length(), n2 = b.length();
		int n = Math.abs(n1-n2);
		StringBuilder a1 = new StringBuilder(a);
		StringBuilder b1 = new StringBuilder(b);

		if (n1 > n2) {
			for (int i = 0; i < n; i++) {
				b1 = new StringBuilder("0").append(b1);
			}
		} else if (n2 > n1) {
			for (int i = 0; i < n; i++) {
				a1 = new StringBuilder("0").append(a1);
			}
			n1 = n2;
		}

		a1 = a1.reverse();
		b1 = b1.reverse();
		int index = 0;
		StringBuilder res = new StringBuilder("");

		for (int i = 0; i < n1; i++) {
			int t = (a1.charAt(i) - '0') + (b1.charAt(i) - '0') + index;
			if (t == 0 || t == 1) {
				res.append(t);
				index = 0;
			} else if (t == 2) {
				res.append("0");
				index = 1;
			} else if (t == 3) {
				res.append("1");
				index = 1;
			}
		}

		if (index != 0) {
			res.append(index);
		}

		return res.reverse().toString();
	}
}
