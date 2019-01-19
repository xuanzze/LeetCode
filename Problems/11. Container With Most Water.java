public int maxArea(int[] height) {
    int water = 0, i = 0, j = height.length - 1;
    while (i < j) {
        int min = Math.min(height[i], height[j]);
        water = Math.max(water, (j - i) * min);
        while (height[i] <= min && i < j)    i++;
        while (height[j] <= min && i < j)   j--;
    }
    return water;
}
