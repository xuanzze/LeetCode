public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> list = new LinkedList<String>();

    for (int begin = 0, end; begin < words.length; begin = end) {
        int len = -1;
        for (end = begin; end < words.length && len + words[end].length() + 1 <= maxWidth; end++)
            len += words[end].length() + 1;

        StringBuilder strBuilder = new StringBuilder(words[begin]);
        int space = 1, extra = 0;
        if (end != begin + 1 && end != words.length) { // not 1 char, not last line
            space = (maxWidth - len) / (end - begin - 1) + 1;
            extra = (maxWidth - len) % (end - begin - 1);
        }
        for (int i = begin + 1; i < end; i++) {
            for (int s = space; s > 0; s--)
                strBuilder.append(' ');
            if (extra-- > 0)
                strBuilder.append(' ');
            strBuilder.append(words[i]);
        }
        int strLen = maxWidth - strBuilder.length();
        while (strLen-- > 0)
            strBuilder.append(' ');
        list.add(strBuilder.toString());
    }
    return list;
}
