public int lengthOfLastWord(String s) {
    if (s.length() == 0 || s == null) return 0;
    int len = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        if(s.charAt(i) != ' ') len++;
        else if (len == 0) continue;
        else break;
    }
    return len;
}
