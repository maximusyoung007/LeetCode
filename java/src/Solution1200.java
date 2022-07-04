import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 * 示例 1：
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 *
 * 示例 2：
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 *
 * 示例 3：
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *
 */
public class Solution1200 {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		List<Integer> a = Arrays.stream(arr).boxed().collect(Collectors.toList());
		Collections.sort(a);
		List<List<Integer>> result = new ArrayList<>();

		int min = Integer.MAX_VALUE;
		for (int i = 0, j = 1; j < a.size(); i++, j++) {
			if (a.get(j) - a.get(i) <= min) {
				if (a.get(j) - a.get(i) < min && result.size() != 0) {
					result.clear();
				}
				min = a.get(j) - a.get(i);
				Integer[] t = new Integer[] {a.get(i), a.get(j)};
				List<Integer> ps = Arrays.asList(t);
				result.add(ps);
			}
		}
		return result;
	}
}