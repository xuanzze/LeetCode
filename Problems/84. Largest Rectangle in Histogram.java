public int largestRectangleArea(int[] heights) {
    return largest(heights, 0, heights.length-1);
}

private int largest(int[] heights, int start, int end) {
    if (start > end) return 0;
    if (start == end) return heights[start];
    boolean sorted = true;
    int min = start;
    for (int i = start+1; i <= end; i++) {
        if (heights[i] < heights[i-1]) sorted = false;
        if (heights[i] < heights[min]) min = i;
    }

    if (sorted) {
        int max = heights[start] * (end - start + 1);
        for (int i = start+1; i <= end; i++) 
            max = Math.max(max, heights[i] * (end - i + 1));
        return max;
    }

    return Math.max(Math.max(largest(heights, start, min-1), largest(heights, min+1, end)), heights[min] * (end - start + 1));
}
