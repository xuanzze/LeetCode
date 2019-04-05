public int minimumTotal(List<List<Integer>> triangle) {
	int n = triangle.size();
	int[] min = new int[n];
	for (int i = 0; i < n; i++)
		min[i] = triangle.get(n-1).get(i);
	for (int layer = n - 2; layer >= 0; layer--) {
		List<Integer> row = triangle.get(layer);
		for (int i = 0; i <= layer; i++)
			min[i] = Math.min(min[i], min[i + 1]) + row.get(i);
	}
	return min[0];
}
