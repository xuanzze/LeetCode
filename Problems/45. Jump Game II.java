// bfs

public int jump(int[] nums) {
    if (nums.length < 2)    return 0;
    int level = 0, i = 0, currentMax = 0, nextMax = 0;
    while (i <= currentMax) {
        level++;
        for (; i <= currentMax; i++) {
            nextMax = Math.max(nextMax, nums[i] + i);  // 找到能跳到最远的的位置，这样下一level中的点都是用最小跳数能到达的
            if (nextMax >= nums.length - 1)
                return level;
        }
        currentMax = nextMax;
    }
    return 0;
}
