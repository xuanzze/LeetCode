public int missingNumber(int[] nums) {
    int res = nums.length;
    for(int i=0; i<nums.length; i++){
        res = res ^ i ^ nums[i]; // a^b^b = a
    }
    return res;
}