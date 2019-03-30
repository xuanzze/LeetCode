public List<List<Integer>> levelOrderBottom(TreeNode root) {
	List<List<Integer>> res = new LinkedList<>();
	Queue<TreeNode> queue = new LinkedList<>();

	if (root == null)   return res;
	queue.offer(root);
	while (! queue.isEmpty()) {
		int levelSize = queue.size();
		List<Integer> subList = new ArrayList<>();
		for (int i = 0; i < levelSize; i++) {
			if (queue.peek().left != null)
				queue.offer(queue.peek().left);
			if (queue.peek().right != null)
				queue.offer(queue.peek().right);
			subList.add(queue.poll().val);
		}
		res.add(0, subList);
	}
	return res;
}
