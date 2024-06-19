import java.util.ArrayList;
import java.util.List;

/**
 * example: 2-1-1
 * result: 2, 0
 */
public class Solution0241 {
	public List<Integer> diffWaysToCompute(String expression) {
		List<Integer> result = new ArrayList<>();
		if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*")) {
			result.add(Integer.parseInt(expression));
			return result;
		}

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
				List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
				List<Integer> rightList = diffWaysToCompute(expression.substring(i+1));
				for (Integer left : leftList) {
					for (Integer right : rightList) {
						if (expression.charAt(i) == '+') {
							result.add(left+right);
						} else if (expression.charAt(i) == '-') {
							result.add(left-right);
						} else if (expression.charAt(i) == '*') {
							result.add(left*right);
						}
					}
				}
			}
		}

		return result;
	}
}
