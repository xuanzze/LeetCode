public boolean canPartition(int[] nums) {
    int sum = 0;
    
    for (int num : nums) {
        sum += num;
    }
    
    if ((sum & 1) == 1) {
        return false;
    }
    sum /= 2;
    
    int n = nums.length;
    boolean[] dp = new boolean[sum+1];
    Arrays.fill(dp, false);
    dp[0] = true;
    
    for (int num : nums) {
        for (int i = sum; i >= num; i--) {	//因为dp[i]是从dp[i-num]得到的，所以如果i是从小到大递增，dp[i]从dp[i-num]得到的值可能被更新过，不是上一轮的值，而是上一轮的值
                dp[i] = dp[i] || dp[i-num];
        }
    }
    
    return dp[sum];
}
