public String minWindow(String s, String t) {
    int begin = 0, end = 0, head = 0, d = Integer.MAX_VALUE, counter = t.length();
    int[] map = new int[256];
    for (char c: t.toCharArray())
        map[c]++;
    while (end < s.length()) {
        if (map[s.charAt(end++)]-- > 0)
            counter--;
        while (counter == 0) {
            if (end - begin < d)    d = end - (head = begin);
            if (map[s.charAt(begin++)]++ == 0)   counter++;
        }
    }
    return d == Integer.MAX_VALUE ? "": s.substring(head, head + d);
}
