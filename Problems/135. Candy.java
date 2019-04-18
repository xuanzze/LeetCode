public int candy(int[] ratings) {
	int n = ratings.length;
	if (n <= 1) return n;
	int[] num = new int[n];
	for (int i = 0; i < n; i++)
		num[i] = 1;
	for (int i = 1; i < n; i++)
		if (ratings[i] > ratings[i-1])
			num[i] = num[i-1] + 1;
	for (int i = n - 1; i > 0; i--)
		if (ratings[i-1] > ratings[i])
			num[i-1] = Math.max(num[i-1], num[i] + 1);
	int res = 0;
	for (int i = 0; i < n; i++)
		res += num[i];
	return res;
}
