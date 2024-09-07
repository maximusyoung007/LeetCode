
public class Solution0307 {
	/**
	 *  使用线段树
	 *  使用数组d保存线段树，根节点为编号1，d[i]维护的是这个节点表示的区间总和
	 *  以数组 a=[10,11,12,13,14]为例子
	 *  d[1]=60[1,5]
	 *  d[2]=33[1,3] d[3]=27[4,5]
	 *  d[4]=21[1,2] d[5]=12[3,3] d[6]=13[4,4] d[7]=14[5,5]
	 *  d[8]=10[1,1] d[9]=11[2,2]
	 *
	 *  d[1]=60[0,4]
	 *  d[2]=33[0,2] d[3]=27[3,4]
	 *  d[4]=21[0,1] d[5]=12[2,2] d[6]=13[3,3] d[7]=14[4,4]
	 * 	d[8]=10[0,0] d[9]=11[1,1]
	 *
	 *  di的左儿子节点为d2*i,右儿子节点为d2*i+1
	 *  di区间为[s,t]
	 *  左儿子区间为[s,(s+t)/2],右儿子区间为[(s+t)/2+1,t]
	 *
	 */
	public static void main(String[] args) {
//		int[] nums = new int[] {10, 11, 12, 13, 14};
//		int[] nums = new int[] {1, 3, 5};
//		int[] nums = new int[] {0,9,5,7,3};
		int[] nums = new int[] {7,2,7,2,0};
		/**
		 *  dp[1]=18[0,4] 24 19 26
		 *	dp[2]=16[0,2] 11 18 dp[3]=2[3,4] 8
		 *	dp[4]=9[0,1] 4 11 dp[5]=7[2,2] dp[6]=2[3,3] dp[7]=0[4,4] 6
		 *	dp[8]=7[0,0] 2 9 dp[9]=2[1,1]
		 */

		NumArray numArray = new NumArray(nums);
		numArray.update(4,6);
		numArray.update(0,2);
		numArray.update(0,9);
		System.out.println(numArray.sumRange(4, 4));
		numArray.update(3,8);
		System.out.println(numArray.sumRange(0, 4));
//		System.out.println(numArray.up(4, 1));
//		int[] d = numArray.getD();
//		for (int i : d) {
//			System.out.println(i);
//		}
//		System.out.println(numArray.sumRange(4,4));
//		System.out.println(numArray.sumRange(2,4));
//		System.out.println(numArray.sumRange(3,3));
//		numArray.update(4,5);
//		numArray.update(1,7);
//		numArray.update(0,8);
//		System.out.println(numArray.sumRange(1, 2));
//		numArray.update(1, 9);
//		System.out.println(numArray.sumRange(4, 4));
//		numArray.update(1,2);
//		System.out.println(numArray.sumRange(0, 2));


	}

	static class NumArray {
		int[] d;
		int[] a;

		public NumArray(int[] nums) {
			a = nums;
			int len = nums.length;
			d = new int[len << 2];
			build(0, len - 1, 1);
		}

		public void update(int index, int val) {
			update(index, val, 0, a.length - 1, 1);
			a[index] = val;
		}

		void update(int index, int c, int s, int t, int p) {
			if (index == s && index == t) {
				d[p] = d[p] - a[index] + c;
				return;
			}

			int mid = s + ((t - s) >> 1);

			if (index <= mid) {
				update(index, c, s, mid, p * 2);
			}
			if (index > mid) {
				update(index, c, mid + 1, t, p * 2 + 1);
			}

			d[p] = d[2 * p] + d[2 * p + 1];
		}

		public int sumRange(int left, int right) {
			return getSum(left, right, 0, a.length - 1, 1);
		}

		public int getSum(int l, int r, int s, int t, int p) {
			// 当前区间为询问区间的子集时直接返回当前区间的和
			if (l <= s && t <= r) {
				return d[p];
			}

			int mid = s + ((t - s) >> 1), sum = 0;
			//和当前区间左半区间有交集
			if (l <= mid) {
				sum += getSum(l, r, s, mid, p * 2);
			}
			//和当前区间右半区间有交际
			if (r > mid) {
				sum += getSum(l, r, mid+1, t, p*2+1);
			}
			return sum;
		}

		public void build(int s, int t, int p) {
			//递归到达了叶子节点
			if (s == t) {
				d[p] = a[s];
				return;
			}

			int mid = s + ((t - s) >> 1);

			build(s, mid, p * 2);
			build(mid + 1, t, p * 2 + 1);
			d[p] = d[p*2] + d[p*2+1];
		}

		public int[] getD() {
			return d;
		}

		public void setD(int[] d) {
			this.d = d;
		}
	}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
}
