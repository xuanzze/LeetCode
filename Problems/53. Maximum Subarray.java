public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for(int i : nums){
        sum = sum + i;
        max = Math.max(max, sum);
        if(sum < 0){
            sum = 0;
        }
    }
    return max;
}
