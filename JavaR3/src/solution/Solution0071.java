package solution;

import java.util.Stack;

public class Solution0071 {
	public String simplifyPath(String path) {
		/**
		 * 始终以斜杠 '/' 开头。
		 * 两个目录名之间必须只有一个斜杠 '/' 。
		 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
		 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）
		 * ./
		 * .///
		 * ../
		 * ..///
		 * ..../
		 */
		Stack<Character> stack = new Stack<>();
		if (!path.startsWith("/")) {
			stack.push('/');
		}

		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);

			if (c == '.') {
				stack.push('.');
			} else if (c == '/') {
				if (stack.isEmpty()) {
					stack.push('/');
					continue;
				}
				if (stack.peek() == '/') {
					stack.pop();
					stack.push(c);
				} else if (stack.peek() == '.') {
					int t = 3;
					char t2 = ' ', t3 = ' ';
					while (!stack.isEmpty() && t > 0) {
						if (t == 3) {
							stack.pop();
						}
						if (t == 2) {
							t2 = stack.pop();
						}
						if (t == 1) {
							t3 = stack.pop();
						}
						t--;
					}

					//两个..
					if (t2 == '.' && t3 != '.') {
						while (!stack.isEmpty() && stack.peek() != '/') {
							stack.pop();
						}
						if (stack.size() > 1) {
							stack.pop();
						}
//						stack.push(t3);
						stack.push(c);
					} else if (t2 != '.') {
						//一个.
						stack.push(t3);
						stack.push(t2);
						while (stack.size() > 1 && stack.peek() == '/') {
							stack.pop();
						}
						stack.push(c);
					} else if (t2 == '.' && t3 == '.') {
						//三个或者三个以上. 可以作为路径名称
						stack.push('.');
						stack.push('.');
						stack.push('.');
						stack.push(c);
					}
				} else {
					stack.push(c);
				}
			} else {
				stack.push(c);
			}

		}

		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		String res = sb.reverse().toString();
		if (res.length() > 1 && res.charAt(res.length() - 1) == '/') {
			res = res.substring(0, res.length()-1);
		}

		return res;
	}
}
