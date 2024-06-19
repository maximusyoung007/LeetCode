//10进制转化为26进制
public class Solution0168 {
	public String convertToTitle(int columnNumber) {
		StringBuilder sb = new StringBuilder();
		while (columnNumber >= 26) {
			int num = columnNumber % 26;
			columnNumber /= 26;
			if (num == 0) {
				sb.append('Z');
				//向更高位借1
				columnNumber -= 1;
			} else {
				char t = (char) (num - 1 + 'A');
				sb.append(t);
			}
		}
		if (columnNumber > 0) {
			sb.append((char) (columnNumber - 1 + 'A'));
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		int a = 26;
		int t = a-1 + 'A';
		char c = (char) t;
		System.out.println(t);
		System.out.println(c);

		Solution0168 solution0168 = new Solution0168();
//		System.out.println(solution0168.convertToTitle(1));
//		System.out.println(solution0168.convertToTitle(28));
//		System.out.println(solution0168.convertToTitle(701));
//		System.out.println(solution0168.convertToTitle(2147483647));
		System.out.println(solution0168.convertToTitle(52));
		System.out.println(solution0168.convertToTitle(53));
		System.out.println(solution0168.convertToTitle(26));
	}
}
