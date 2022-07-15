public class Solution0558 {
	public QuadTree intersect(QuadTree quadTree1, QuadTree quadTree2) {
		if (quadTree1.isLeaf) {
			if (quadTree1.val) {
				return new QuadTree(true, true, null, null, null, null);
			}
			return quadTree2;
		}
		if (quadTree2.isLeaf) {
			if (quadTree2.val) {
				return new QuadTree(true, true, null, null, null, null);
			}
			return quadTree1;
		}
		QuadTree topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
		QuadTree topRight = intersect(quadTree1.topRight, quadTree2.topRight);
		QuadTree bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
		QuadTree bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
		if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
			&& topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
			return new QuadTree(topLeft.val, true, null, null, null, null);
		}
		return new QuadTree(false, false, topLeft, topRight, bottomLeft, bottomRight);
	}

}
class QuadTree {
	public boolean val;
	public boolean isLeaf;
	public QuadTree topLeft;
	public QuadTree topRight;
	public QuadTree bottomLeft;
	public QuadTree bottomRight;

	public QuadTree() {}

	public QuadTree(boolean _val,boolean _isLeaf,QuadTree _topLeft,QuadTree _topRight,QuadTree _bottomLeft,QuadTree _bottomRight) {
		val = _val;
		isLeaf = _isLeaf;
		topLeft = _topLeft;
		topRight = _topRight;
		bottomLeft = _bottomLeft;
		bottomRight = _bottomRight;
	}
};