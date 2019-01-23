public void rotate(int[][] matrix) {
    int s = 0, e = matrix.length - 1;
	//上下对称反转
    while(s < e){
        int[] temp = matrix[s];
        matrix[s] = matrix[e];
        matrix[e] = temp;
        s++; e--;
    }

	//对角线对称反转
    for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < i; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
}
