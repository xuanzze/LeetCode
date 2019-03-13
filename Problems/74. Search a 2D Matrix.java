public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0)
        return false;
    int row = matrix.length, col = matrix[0].length;
    int begin = 0, end = row * col - 1;
    while (begin <= end) {
        int mid = (begin + end) >> 1, val = matrix[mid / col][mid % col];
        if  (val == target)
            return true;
        else if (val < target)
            begin = mid + 1;
        else
            end = mid - 1;
    }
    return false;
}
