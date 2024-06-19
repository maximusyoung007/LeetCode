public class Solution0067 {
	public String addBinary(String a, String b) {
		StringBuilder a1 = new StringBuilder(a).reverse();
		StringBuilder b1 = new StringBuilder(b).reverse();
		StringBuilder res = new StringBuilder();

		int len = a1.length() <= b1.length() ? a1.length() : b1.length();

		int i = 0;
		int index = 0;
		while (i < len) {
			int t = (a1.charAt(i) - '0') + (b1.charAt(i) - '0') + index;
			if (t == 2) {
				t = 0;
				index = 1;
			} else if (t == 3) {
				t = 1;
				index = 1;
			} else{
				index = 0;
			}
			res.append(t);
			i++;
		}

		while (i < a1.length()) {
			int t = (a1.charAt(i) - '0') + index;
			if (t == 2) {
				t = 0;
				index = 1;
			} else if (t == 3) {
				t = 1;
				index = 1;
			} else{
				index = 0;
			}
			res.append(t);
			i++;
		}

		while (i < b1.length()) {
			int t = (b1.charAt(i) - '0') + index;
			if (t == 2) {
				t = 0;
				index = 1;
			} else if (t == 3) {
				t = 1;
				index = 1;
			} else {
				index = 0;
			}
			res.append(t);
			i++;
		}
		if (index == 1) {
			res.append(index);
		}
		return res.reverse().toString();
	}
}
