function treeNode(val) {
    this.val = val;
    this.left = this.right = null;
}
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function (root) {
    if(root == null) 
        return null;
    invertTree(root.left);
    invertTree(root.right);
    var left = root.left;
    root.left = root.right;
    root.right = left;
    return root;
};

//test
var midOrder = function (root) {
    if(root.left != null) {
        midOrder(root.left);
    }
    console.log(root.val);
    if(root.right != null) {
        midOrder(root.right);
    }
}
var root = new treeNode(4);
var a1 = new treeNode(2);
var a2 = new treeNode(7);
root.left = a1;
root.right = a2;
var b1 = new treeNode(1);
var b2 = new treeNode(3);
var b3 = new treeNode(6);
var b4 = new treeNode(9);
a1.left = b1;
a1.right = b2;
a2.left = b3;
a2.right = b4;
midOrder(root);
var root2 = invertTree(root);
console.log("--------------------");
midOrder(root2);
