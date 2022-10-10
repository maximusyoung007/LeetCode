/**
 * 解析：
 * 给定两个升序排列的数组n1,n2，使得lower<=n2[j]-n1[i]<=upper
 * 首先考察n1的第一个元素，不断将l指针向右移动，直到n2[l]>=n1[0]+lower,则l及其右边的元素都大于n1[0]+lower
 * 再不断将r元素右移，直到n2[r]>n1[0]+upper,则r左边的元素均小于n1[0]+upper,
 * 故区间[l,r)中所有的下标j都满足lower<=n2[j]-n1[0]<=upper
 * 以此类推，对于n1中的每一个下标，都有对应的区间[l,r)
 * 为什么数组排序前后所求的区间数量不会改变呢？
 * 对前缀和数组排序并不会修改数组中元素的值，只是改变了元素的位置。
 * 设想，左、右两段区间left-mid,mid+1-right符合要求的区间数量已经计算出来了，则整个left-right符合要求的区间情况可能是：
 * 1、i, j都在左区间
 * 2、i, j都在右区间
 * 3、一个端点在左区间，一个端点在右区间
 * 对于第三种情况，是左端区间的每个数和右段区间的每个数比较，值改变顺序改变并不影响比较的结果
 *  nums[2,-1,4,3],前缀和sum[i]表示0~i-1位的前缀和
 *
 *  首先计算nums的前缀和sums,根据sums计算原数组的区间和。0<=start<=end<=n,nums下标范围是[start,end-1]，
 *  该区间的长度是end-start,区间和是sums[end]-sums[start]。
 *  start>=end时，区间的长度是0
 *  start<end时，将sums下标范围[start,end]的子数组分成两个更短的子数组，对两个更短的子数组排序后合并，
 *  同时计算[lower,upper]内区间和的个数
 *  1、取start,end的平均值mid,分成两个数组
 *  2、对两个数组排序并计算区间和的个数，得到两个升序的子数组和两个子数组分别包含的区间和的个数
 *  3、计算两个升序子数组之间的区间和的个数，左边的指针在[start,mid]中移动，右边的指针在[mid,right]中，
 *  找到lower<=sum[j]-sum[i]<=upper，则以i为区间开始位置的区间和的个数为right-left
 *  4、计算两个升序子数组之间的区间和个数后，合并成两个升序子数组
 */
public class Solution0327 {
	public int countRangeSum(int[] nums, int lower, int upper) {
		long[] sums = new long[nums.length + 1];
		long s = 0;
		for (int i = 0; i < nums.length; i++) {
			s += nums[i];
			sums[i + 1] = s;
		}
		int res = countRange(sums, lower, upper, 0, sums.length - 1);
		return res;
	}

	public int countRange(long[] sums, int lower, int upper, int start, int end) {
		if (start >= end) {
			return 0;
		} else {
			int mid = (start + end) / 2;
			int res1 = countRange(sums, lower, upper, start, mid);
			int res2 = countRange(sums, lower, upper, mid + 1, end);
			int res = res1 + res2;

			int i = start;
			int l = mid + 1;
			int r = mid + 1;
			while (i <= mid) {
				while (l <= end && sums[l] - sums[i] < lower) {
					l++;
				}
				while (r <= end && sums[r] - sums[i] <= upper) {
					r++;
				}
				res += (r - l);
				i++;
			}

			long[] sorted = new long[end - start + 1];
			int i1 = start, i2 = mid + 1;
			i = 0;
			while (i1 <= mid && i2 <= end) {
				if (sums[i1] < sums[i2]) {
					sorted[i++] = sums[i1++];
				} else {
					sorted[i++] = sums[i2++];
				}
			}
			while (i1 <= mid) {
				sorted[i++] = sums[i1++];
			}

			while (i2 <= end) {
				sorted[i++] = sums[i2++];
			}


			for (int j = 0; j < sorted.length; j++) {
				sums[start + j] = sorted[j];
			}
			return res;
		}
	}
}
