public void nextPermutation(int[] nums) {
    int n = nums.length;
    if (n < 2)
        return ;
    int index = n - 1;
    while (index > 0) {
        if (nums[index - 1] < nums[index])
            break;
        index--;
    }
    if (index == 0)
        reverse(nums, 0, n - 1);
    else {
        int j = n - 1;
        while (j >= index) {
            if (nums[j] > nums[index - 1])
                break;
            j--;
        }
        swap(nums, j, index - 1);
        reverse(nums, index, n - 1);
    }
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}

private void reverse(int[] nums, int begin, int end) {
    while (begin < end)
        swap(nums, begin++, end--);
}
