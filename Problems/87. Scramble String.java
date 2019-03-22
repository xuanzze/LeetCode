public boolean isScramble(String s1, String s2) {
    int len1 = s1.length(), len2 = s2.length();
    if (s1.equals(s2))  return true;
    if (len1 == 0) return true;
    int[] cnt = new int[26];
    for (int i = 0; i < len1; i++) {
        cnt[s1.charAt(i) - 'a']++;
        cnt[s2.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++)
        if (cnt[i] != 0)
            return false;
    for (int i = 1; i < len1; i++) {
        if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
            return true;
        if (isScramble(s1.substring(0, i), s2.substring(len1 - i)) && isScramble(s1.substring(i), s2.substring(0, len1 - i)))
            return true;
    }
    return false;
}
