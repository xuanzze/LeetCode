public String getPermutation(int n, int k) {
    List<Integer> nums = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    int[] factorial = new int[n + 1];

    for (int i = 1; i <= n; i++)
        nums.add(i);
    factorial[0] = 1;
    for (int i = 1; i <= n; i++)
        factorial[i] = i * factorial[i-1];

    k--;
    for (int i = 1; i <= n; i++) {
        int index = k / factorial[n - i];
        sb.append(nums.remove(index));
        k -= index * factorial[n - i];
    }
    return sb.toString();
}
