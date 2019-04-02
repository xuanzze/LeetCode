public List<List<Integer>> pathSum(TreeNode root, int sum) {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> tempList = new ArrayList<>();
	helper(res, tempList, root, sum);
	return res;
}

private void helper(List<List<Integer>> res, List<Integer> tempList, TreeNode root, int remain) {
	if (root == null)   return ;

	tempList.add(root.val);
	if (root.left == null && root.right == null && root.val == remain) {
		res.add(new ArrayList<>(tempList));
	} else {
		helper(res, tempList, root.left, remain - root.val);
		helper(res, tempList, root.right, remain - root.val);
	}
	tempList.remove(tempList.size() - 1);
}
