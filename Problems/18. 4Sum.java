public List<List<Integer>> fourSum(int[] nums, int target) {
    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    int len = nums.length;
    if (nums == null || len < 4)
        return res;

    Arrays.sort(nums);

    int max = nums[len - 1];
    if (4 * nums[0] > target || 4 * max < target)
        return res;

    for (int i = 0; i < len; i++) {
        int cur = nums[i];
        if (i > 0 && cur == nums[i - 1])// avoid duplicate
            continue;
        if (cur + 3 * max < target) // z is too small
            continue;
        if (4 * cur > target) // z is too large
            break;
        if (4 * cur == target) { // z is the boundary
            if (i + 3 < len && nums[i + 3] == cur)
                res.add(Arrays.asList(cur, cur, cur, cur));
            break;
        }
        threeSumForFourSum(nums, target - cur, i + 1, len - 1, res, cur);
    }
    return res;
}

private void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList, int z1) {
    if (low + 1 >= high)
        return;

    int max = nums[high];
    if (3 * nums[low] > target || 3 * max < target)
        return;

    for (int i = low; i < high - 1; i++) {
        int cur = nums[i];
        if (i > low && cur == nums[i - 1]) // avoid duplicate
            continue;
        if (cur + 2 * max < target) // cur is too small
            continue;

        if (3 * cur > target) // cur is too large
            break;

        if (3 * cur == target) { // cur is the boundary
            if (i + 1 < high && nums[i + 2] == cur)
                fourSumList.add(Arrays.asList(z1, cur, cur, cur));
            break;
        }

        twoSumForFourSum(nums, target - cur, i + 1, high, fourSumList, z1, cur);
    }
}

private void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList, int z1, int z2) {
    if (low >= high)
        return;

    if (2 * nums[low] > target || 2 * nums[high] < target)
        return;

    int i = low, j = high, sum, x;
    while (i < j) {
        sum = nums[i] + nums[j];
        if (sum == target) {
            fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

            x = nums[i];
            while (++i < j && x == nums[i]) // avoid duplicate
                ;
            x = nums[j];
            while (i < --j && x == nums[j]) // avoid duplicate
                ;
        }
        if (sum < target)
            i++;
        if (sum > target)
            j--;
    }
}
