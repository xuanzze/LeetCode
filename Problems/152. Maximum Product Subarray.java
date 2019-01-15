public int maxProduct(int[] nums) {
    int res = nums[0];
    for (int i = 1, max = res, min = res; i < nums.length; i++) {
        if (nums[i] < 0) {
            int temp = max;
            max = min;
            min = temp;
        }
        max = Math.max(nums[i], nums[i] * max);
        min = Math.min(nums[i], nums[i] * min);
        res = Math.max(res, max);
    }
    return res;
}
