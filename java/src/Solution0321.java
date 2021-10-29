import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 示例 1:
 *
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 *
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 *
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	Integer[] max = new Integer[k];
    	for (int i = 0; i < k; i++) {
    		max[i] = 0;
		}
		for (int i = 1; i < k; i++) {
			int j = k - i;
			if (i > nums1.length || j > nums2.length) {
				continue;
			} else {
				Integer[] n1 = maxNumber(nums1, i);
				Integer[] n2 = maxNumber(nums2, j);
				Integer[] num = merge(n1, n2, k);
				if (compare(num, max)) {
					max = num.clone();
				}
			}
		}
		int[] result = new int[k];
		for (int i = 0; i < max.length; i++) {
			result[i] = max[i];
		}
		return result;
    }

    public Integer[] merge(Integer[] nums1, Integer[] nums2, int k) {
		Integer[] res = new Integer[k];
		for (int i = 0; i < res.length; i++) {
			res[i] = 0;
		}
		int i = 0, j = 0, t = 0;
		while (i < nums1.length && j < nums2.length && t < k) {
			if (nums1[i] > nums2[j]) {
				res[t] = nums1[i];
				t++;
				i++;
			} else if (nums1[i] < nums2[j]){
				res[t] = nums2[j];
				t++;
				j++;
			} else {
				int flag = -1;
				int i1 = i, j1 = j;
				while (i1 < nums1.length && j1 < nums2.length && flag == -1) {
					if (nums1[i1] == nums2[j1]) {
						i1++;
						j1++;
					} else if (nums1[i1] > nums2[j1]) {
						flag = 1;
					} else if (nums2[j1] > nums1[i1]) {
						flag = 2;
					}
				}
				if (i1 >= nums1.length) {
					flag = 2;
				} else if (j1 >= nums2.length) {
					flag = 1;
				}
				if (flag == 1) {
					res[t] = nums1[i];
					t++;
					i++;
				} else {
					res[t] = nums2[j];
					t++;
					j++;
				}
			}
		}
		while (i < nums1.length && t < k) {
			res[t] = nums1[i];
			i++;
			t++;
		}
		while (j < nums2.length && t < k) {
			res[t] = nums2[j];
			t++;
			j++;
		}
		return res;
	}

	//求k个数组成的最大子序列,则去除nums.length-k个数
	public Integer[] maxNumber(int[] nums, int k) {
    	List<Integer> res = new ArrayList<>();
    	//去除left个
    	int left = nums.length - k;
		Stack<Integer> stack = new Stack<>();
		int time = 0;
		for (int i = 0; i < nums.length; i++) {
			if (stack.size() == 0) {
				stack.push(nums[i]);
			} else {
				if (time < left && nums[i] > stack.peek()) {
					while (time < left && !stack.isEmpty() && nums[i] > stack.peek()) {
						stack.pop();
						time++;
					}
				}
				stack.push(nums[i]);
			}
		}
		while (!stack.isEmpty()) {
			res.add(0, stack.pop());
		}
		return res.toArray(new Integer[res.size()]);
	}

	public boolean compare(Integer[] nums1, Integer[] nums2) {
    	for (int i = 0; i < nums1.length; i++) {
    		if (nums1[i] > nums2[i]) {
    			return true;
			} else if (nums1[i] == nums2[i]) {
    			continue;
			} else {
    			return false;
			}
		}
    	return false;
	}
}
