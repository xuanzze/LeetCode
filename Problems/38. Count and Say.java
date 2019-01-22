public String countAndSay(int n) {
    if (n <= 0) return "-1";
    String result = "1";

    for(int i = 1; i < n; i ++)
        result = build(result);
    return result;
}

private String build(String s) {
    char c = s.charAt(0);
    int count = 1;
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == c) {
            count++;
        } else {
            sb.append(count);
            sb.append(c);
            c = s.charAt(i);
            count = 1;
        }
    }
    sb.append(count);
    sb.append(c);
    return sb.toString();
}
