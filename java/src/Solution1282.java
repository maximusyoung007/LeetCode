import java.util.ArrayList;
import java.util.List;

public class Solution1282 {
	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> res = new ArrayList<>();
		List<List<Integer>> temp = new ArrayList<>();
		for (int i = 0; i < groupSizes.length + 1; i++) {
			temp.add(new ArrayList<>());
		}
		for (int i = 0; i < groupSizes.length; i++) {
			List<Integer> t = temp.get(groupSizes[i]);
			t.add(i);
			if (t.size() == groupSizes[i]) {
				List<Integer> r = new ArrayList<>(t);
				res.add(r);
				t.clear();
			}
		}
		return res;
	}
}
