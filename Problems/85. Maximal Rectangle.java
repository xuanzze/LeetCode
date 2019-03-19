public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
        return 0;
    int m = matrix.length, n = matrix[0].length, maxArea = 0;
    int[] left = new int[n], right = new int[n], height = new int[n];
    Arrays.fill(right, n-1);
    for (int i = 0; i < m; i++) {
        int rightBoundary = n - 1;
        for (int j = n - 1; j >= 0; j--) {
            if (matrix[i][j] == '1') {
                right[j] = Math.min(right[j], rightBoundary);
            } else {
                right[j] = n - 1;
                rightBoundary = j - 1;
            }
        }
        int leftBoundary = 0;
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == '1') {
                left[j] = Math.max(left[j], leftBoundary);
                height[j]++;
                maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
            } else {
                height[j] = 0;
                left[j] = 0;
                leftBoundary = j + 1;
            }
        }
    }
    return maxArea;
}
