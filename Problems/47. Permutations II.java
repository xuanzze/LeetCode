public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0)   return res;
    boolean[] used = new boolean[nums.length];
    Arrays.sort(nums);
    dfs(nums, used, new ArrayList<>(), res);
    return res;
}

private void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
    if (list.size() == nums.length) {
        res.add(new ArrayList<>(list));
        return ;
    }
    for (int i = 0; i < nums.length; i++) {
        if (used[i])    continue;
        if (i > 0 && nums[i] == nums[i-1] && !used[i-1])    continue;
        used[i] = true;
        list.add(nums[i]);
        dfs(nums, used, list, res);
        list.remove(list.size() - 1);
        used[i] = false;
    }
}
