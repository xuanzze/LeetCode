class Solution {
    int[] orig;
    int[] temp;
    public Solution(int[] nums) {
        //orig = new int[nums.length];
        temp = new int[nums.length];
        orig = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return orig;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i=0; i<orig.length; i++) {
            temp[i] = orig[i];
        }
        Random rand = new Random();
        for (int i=0; i<orig.length; i++) {
            int t = rand.nextInt(orig.length);
            int tem = temp[i];
            temp[i] = temp[t];
            temp[t] = tem;
        }
        return temp;
    }
}
