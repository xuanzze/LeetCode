public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> ans = new LinkedList<>();
    if (words.length == 0)
        return Collections.emptyList();
    Map<String, Integer> wordsFreqMap = new HashMap<>();
    for (String word : words)
        wordsFreqMap.put(word, wordsFreqMap.getOrDefault(word, 0) + 1);
    int wordLen = words[0].length();
    int window = words.length * wordLen;
    char[] charArray = s.toCharArray();
    for (int i = 0; i < wordLen; i++) {  // for each character in a word
        for (int j = i; j + window <= s.length(); j += wordLen) {
            Map<String, Integer> map = new HashMap<>();
            for (int k = words.length - 1; k >= 0; k--) {   
                // 从后到前遍历更有效，如果words.length * wordLen距离内出现了超出words中的频次，则说明当前循环内的word到最前这段距离是废了的
                String word = new String(charArray, j + k * wordLen, wordLen);
                int count = map.getOrDefault(word, 0) + 1;
                if (count > wordsFreqMap.getOrDefault(word, 0)) {
                    j += k * wordLen;
                    break;
                } else if (k == 0)
                    ans.add(j);
                else
                    map.put(word, count);
            }
        }
    }
    return ans;
}
