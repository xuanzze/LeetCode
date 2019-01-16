 // 节约运行时间的方法，2肯定是，在奇数中排除是否是质数
public static int countPrimes(int n) {
    if(n<=2)
        return 0;
    boolean[] notPrim = new boolean[n];
    int cnt=1;
    for(int i=3; i<n; i= i+2){
        if(!notPrim[i]) {
            cnt ++;
            for (int j = 3; i * j < n; j= j+2) {
                notPrim[i * j] = true;
            }
        }
    }
    return cnt;
}
