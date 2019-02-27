public String multiply(String num1, String num2) {
    if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "0";
    if(num1.equals("0") || num2.equals("0")) return "0";
    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];
    for (int i = m - 1; i >= 0; i--)
        for (int j = n - 1; j >= 0; j--) {
            int p = i + j + 1;
            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            int sum = mul + pos[p];
            pos[p-1] += sum / 10;
            pos[p] = sum % 10;
        }
    StringBuilder sb = new StringBuilder();
    for (int p: pos)
        if (!(sb.length() == 0 && p == 0))
            sb.append(p);
    return sb.length() == 0? "0": sb.toString();
}
