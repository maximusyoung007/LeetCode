package solution;

public class Solution0427 {
	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;


		public Node() {
			this.val = false;
			this.isLeaf = false;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = topLeft;
			this.topRight = topRight;
			this.bottomLeft = bottomLeft;
			this.bottomRight = bottomRight;
		}
	}

	public Node construct(int[][] grid) {

		int n = grid.length;

		return build(grid, 0, n-1, 0, n-1);
	}

	public Node build(int[][] grid, int startI, int endI, int startJ, int endJ) {
		if (startI > endI || startJ > endJ) {
			return null;
		}
		if (startI == endI && startJ == endJ) {
			return new Node(grid[startI][startJ] == 1, true);
		}

		Node res = new Node(true, false);

		int midI = (startI + endI) / 2;
		int midJ = (startJ + endJ) / 2;

		res.topLeft = build(grid, startI, midI, startJ, midJ);
		res.topRight = build(grid, startI, midI, midJ+1, endJ);
		res.bottomLeft = build(grid, midI+1, endI, startJ, midJ);
		res.bottomRight = build(grid, midI+1, endI, midJ+1, endJ);

		if (res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf && res.bottomRight.isLeaf &&
			res.topLeft.val == res.topRight.val && res.topLeft.val == res.bottomLeft.val
			&& res.topLeft.val == res.bottomRight.val) {
			return new Node(res.topLeft.val, true, null, null, null, null);
		} else {
			res.val = true;
			res.isLeaf = false;
		}

		return res;
	}

	public static void main(String[] args) {
//		int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},
//			{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},
//			{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
//		int[][] grid = {{0,1}, {1,0}};
		int[][] grid = {{1,1,0,0},{0,0,1,1},{1,1,0,0},{0,0,1,1}};
		Solution0427 solution0427 = new Solution0427();
		Node node = solution0427.construct(grid);
		System.out.println(node);
	}
}
