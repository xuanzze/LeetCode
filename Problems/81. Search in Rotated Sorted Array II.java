public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0)
        return false;
    int l = 0, r = nums.length - 1;
    while (l <= r) {
        int mid = (l + r) >> 1;
        if (target == nums[mid])
            return true;
        if (nums[l] < nums[mid]) {
            if (target >= nums[l] && target < nums[mid])
                r = mid - 1;
            else
                l = mid + 1;
        } else if (nums[mid] < nums[r]) {
            if (target > nums[mid] && target <= nums[r])
                l = mid + 1;
            else
                r = mid - 1;
        } else {
            if (nums[l] == nums[mid])   l++;
            if (nums[r] == nums[mid])   r--;
        }
    }
    return false;
}
