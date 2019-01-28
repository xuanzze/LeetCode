public String convert(String s, int numRows) {
    if ( numRows < 2) return s;
    char[] a = s.toCharArray();
    char[] b = new char[a.length];
    int k = 0;
    int p = 2*numRows-2;
    for ( int i = 0; i < numRows; i++){
        for ( int j = 0; j < a.length; j += p){
            if ( j+i < a.length)
                b[k++] = a[j+i];
            if ( i != 0 && i != numRows-1 && j+p-i < a.length)
                b[k++] = a[j+p-i];
        }
    }
    return String.valueOf(b);
}
