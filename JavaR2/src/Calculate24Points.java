import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * @author 杨文俊
 */
public class Calculate24Points {

	//1-9 所有的测试用例
	private static final int[] array = new int[] { 1168, 1277, 1346, 1379, 1399, 1455, 1456, 1489, 1555, 1556, 1668, 2357, 2367, 2468, 2569, 2578, 2888, 3377, 3445,
		3449, 3478, 3479, 3559, 3578, 3689, 4447, 4469, 4477, 4555, 4667, 4669, 4689, 4777, 4789, 5556, 5566, 5567, 5577, 5678, 5688, 5888, 5889,
		6669, 6679, 6789, 6799, 6888, 6889, 6899, 7889 };

	/**
	 * 题目：给定整型数组array，其元素均为4位十进制整数且均不包含数字0，请判断每一个元素是否满足如下规律：
	 * 组成该元素的四个数字（可能重复）是否可以通过恰当的四则运算得出24。
	 * 如数字1118，由于(1+1+1)*8=24，则1118满足规律；数字1111无法通过四则运算得出24，则1111不满足规律。
	 * 请找出数组array中所有满足该规律的元素及其对应的表达式（若有多个表达式则任选其一即可）。
	 * 输出格式如下：
	 * （1）如满足该规律，则输出元素及对应的计算式（需要满足四则运算顺序）并以英文冒号分割，如1118，则输出1118:(1+1+1)*8；
	 * （2）如不满足规律，则输出元素及“no expression“并以英文冒号分割，如1111，则输出1111:no expression；
	 * （3）每个元素占一行；
	 * （4）一个元素对应的表达式有多个时，只需输出一个表达式。
	 * 如数组array={1118, 1111, 4578}，则输出
	 * 1118:(1+1+1)*8 // 不能输出1118:1+1+1*8 或1118:1+1+1)*8
	 * 1111:no expression
	 * 4578:4+5+7+8 //也可输出4578:5+7+4+8或4578:(4+5)+7+8或4578:((4+5)+7)+8等
	 *
	 * 评分方式，给定由50个不包含数字0的4位十进制整数组成的整型数组array，根据输出结果进行评分。
	 * 在1秒内每输出一个正确结果得2分，依次计算，输出50个正确结果得100分。
	 * 超过1秒输出结果的，每超过一个100毫秒，扣减总分的一个0.1倍，依次类推。
	 * 超过2秒未输出结果，不计成绩。
	 * 得分取整数（四舍五入），得分相同时，根据提交时间进行排名。
	 *
	 * 其他要求：
	 * （1）不允许引入自定义外部类，如有必要可使用内部类；
	 * （2）main方法只能在给定的地方添加或修改代码，不能在其他地方添加、修改或删除代码。
	 */
	public static void main(String[] args) {

		System.out.println("开始计算");
		long startTime = System.currentTimeMillis();


		for (int number : array) {
			System.out.print(number + ":");
			boolean canTwoFour = false;
			int[] nums = new int[4];
			int k = 0;
			while (number > 0) {
				int t = number % 10;
				nums[k++] = t;
				number /= 10;
			}
			List<List<Integer>> permuteUnique = allPermuteUnique(nums);

			char[] cal = new char[]{'+', '-', '*', '/'};
			List<List<Character>> permuteCal = allCal(cal);

			StringBuilder expression = new StringBuilder();
			for (List<Integer> pu : permuteUnique) {

				for (List<Character> c : permuteCal) {
					int index = 0;
					int res = pu.get(index);
					expression = expression.append(res);
					for (int i = 0; i < 3; i++) {
						index++;
						if (c.get(i) == '+') {
							res = res + pu.get(index);
							expression.append("+");

						} else if (c.get(i) == '-') {
							res = res - pu.get(index);
							expression.append("-");

						} else if (c.get(i) == '*') {
							res = res * pu.get(index);
							expression.append("*");

						} else if (c.get(i) == '/') {
							if (res % pu.get(index) == 0) {
								res = res / pu.get(index);
								expression.append("/");
							}

						}
						expression.append(pu.get(index));
					}
					if (res == 24) {
						canTwoFour = true;
						break;
					} else {
						expression = new StringBuilder();
					}
				}
				if (canTwoFour) {
					break;
				}
			}


			// main方法只能在此处添加内容，并可删除或修改该处的打印语句
			if (canTwoFour) {
				//如果加减在乘除后面的，要给加减加上括号
				StringBuilder finalExpress = new StringBuilder();
				if ((expression.charAt(1) == '+' || expression.charAt(1) == '-')
					&& (expression.charAt(3) == '*' || expression.charAt(3) == '/')) {
					finalExpress.append("(");
					finalExpress.append(expression.substring(0, 3));
					finalExpress.append(")");
					finalExpress.append(expression.substring(3));
				} else if ((expression.charAt(1) == '+' && expression.charAt(1) == '+' && expression.charAt(5) == '*') ||
					(expression.charAt(1) == '+' && expression.charAt(1) == '+' && expression.charAt(5) == '/') ||
					(expression.charAt(1) == '+' && expression.charAt(1) == '-' && expression.charAt(5) == '*') ||
					(expression.charAt(1) == '+' && expression.charAt(1) == '-' && expression.charAt(5) == '/') ||
					(expression.charAt(1) == '-' && expression.charAt(1) == '+' && expression.charAt(5) == '*') ||
					(expression.charAt(1) == '-' && expression.charAt(1) == '+' && expression.charAt(5) == '/') ||
					(expression.charAt(1) == '-' && expression.charAt(1) == '-' && expression.charAt(5) == '*') ||
					(expression.charAt(1) == '-' && expression.charAt(1) == '-' && expression.charAt(5) == '*')
				) {
					finalExpress.append("(");
					finalExpress.append(expression.substring(0, 5));
					finalExpress.append(")");
					finalExpress.append(expression.substring(5));
				} else {
					finalExpress = expression;
				}
				System.out.println(finalExpress);
			} else {
				System.out.println("no expression");
			}
		}

		long consumedTime = System.currentTimeMillis() - startTime;
		System.out.println("本次计算共耗时" + consumedTime + "毫秒");

	}

	private static List<List<Integer>> allPermuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<Integer> pr = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		boolean[] isVisited = new boolean[nums.length];
		dfs(nums, isVisited, pr, res);
		return res;
	}

	private static List<List<Character>> allCal(char[] cal) {
		List<Character> cr = new ArrayList<>();
		List<List<Character>> crr = new ArrayList<>();
		boolean[] isVisited = new boolean[cal.length];

		dfsCal(cal, cr, crr);
		return crr;
	}

	private static void dfsCal(char[] cal, List<Character> pr, List<List<Character>> res) {

		if (pr.size() >= 3) {
			return;
		}
		//从上一层遍历的后一位开始遍历
		for (int i = 0; i < cal.length; i++) {


			pr.add(cal[i]);
			//isVisited[i] = true;

			if (pr.size() == 3) {
				List<Character> t = new ArrayList<>();
				t.addAll(pr);
				res.add(t);
			}

			dfsCal(cal, pr, res);

			//剪枝
			pr.remove(pr.size() - 1);
			//isVisited[i] = false;

		}
	}

	private static void dfs(int[] nums, boolean[] isVisited, List<Integer> pr, List<List<Integer>> res) {

		for (int i = 0; i < nums.length; i++) {
			if (isVisited[i]) {
				continue;
			}

			//两个数相同的情况：
			//和前一个数相等且前一个数没有访问，则表示是从后一个数开始遍历的
			//这两个数相同，第一轮已经从第一个数遍历过了，因此从第二个数遍历就不需要了
			//多于两个数同理
			boolean finished = false;
			for (int j = 0; j < i; j++) {
				if (nums[j] == nums[i] && !isVisited[j]) {
					finished = true;
				}
			}
			if (finished) {
				continue;
			}

			pr.add(nums[i]);
			isVisited[i] = true;

			if (pr.size() == nums.length) {
				List<Integer> t = new ArrayList<>();
				t.addAll(pr);
				res.add(t);
			}

			dfs(nums, isVisited, pr, res);

			//剪枝
			pr.remove(pr.size() - 1);
			isVisited[i] = false;

		}
	}

}
