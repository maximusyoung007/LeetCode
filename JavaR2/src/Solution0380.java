import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * maximus         2024/10/18      create
 */
public class Solution0380 {
	//维护一个map,一个list，map用来存储val在list中的位置，一个随机数用来实现随机读取
	static class RandomizedSet {
		Map<Integer, Integer> map;
		List<Integer> list;
		Random random;

		public RandomizedSet() {
			map = new HashMap<>();
			list = new ArrayList<>();
			random = new Random();
		}

		public boolean insert(int val) {
			if (map.containsKey(val)) {
				return false;
			}
			list.add(val);
			map.put(val, list.size() - 1);
			return true;
		}

		//将最后一个值赋值给要删除的位置，并删除最后一个
		public boolean remove(int val) {
			if (!map.containsKey(val)) {
				return false;
			}
			int removeIndex = map.get(val);
			int n = list.size() - 1;
			int lastValue = list.get(n);
			//将最后一个值移到removeIndex
			list.set(removeIndex, lastValue);
			//修改最后一个值的下标为removeIndex
			map.put(lastValue, removeIndex);
			//删除最后一个值
			list.remove(n);
			//从map中删除val
			map.remove(val);
			return true;
		}

		public int getRandom() {
			int randomInt = random.nextInt(list.size());
			return list.get(randomInt);
		}
	}
}
