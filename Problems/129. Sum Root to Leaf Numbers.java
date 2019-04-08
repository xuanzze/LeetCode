public int sumNumbers(TreeNode root) {
    return helper(root, 0);
}

private int helper(TreeNode root, int val) {
    if (root == null)   return 0;
    int curVal = val * 10 + root.val;
    if (root.left == null && root.right == null)
        return curVal;
    return helper(root.left, curVal) + helper(root.right, curVal);
}
