class Solution {
    private TreeNode firstNode = null, secondNode = null, prevNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);

        if (prevNode.val >= root.val) {
            if (firstNode == null)
                firstNode = prevNode;
            if (firstNode != null)	// 注意此处不是else，在给firstNode赋值时也给secondNode赋值，如果在后面找到另一符合prevNode.val >= root.val条件的也要赋值
                secondNode = root;
        }
        prevNode = root;

        traverse(root.right);
    }
}
