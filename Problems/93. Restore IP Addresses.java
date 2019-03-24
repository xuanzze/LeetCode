public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    int len = s.length();
    for (int i = 1; i < 4 && i < len - 2; i++) {
        String s1 = s.substring(0, i);
        if (! valid(s1))    continue;
        for (int j = i+1; j < i+4 && j < len-1; j++) {
            String s2 = s.substring(i, j);
            if (! valid(s2))    continue;
            for (int k = j+1; k < j+4 && k < len; k++) {
                String s3 = s.substring(j, k), s4 = s.substring(k);
                if (valid(s3) && valid(s4))
                    res.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
            }
        }
    }
    return res;
}

private boolean valid(String s) {
    int len = s.length();
    if (len == 0 || len > 3 || (s.charAt(0) == '0' && len > 1) || Integer.parseInt(s) > 255)
        return false;
    return true;
}
