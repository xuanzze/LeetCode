public String largestNumber(int[] num) {
    if (num == null || num.length == 0)
        return "0";
    Comparator<String> comp = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            String a = s1 + s2;
            String b = s2 + s1;
            return b.compareTo(a);
        }
    };
    String[] s_num = new String[num.length];
    for (int i = 0; i < num.length; i++) {
        s_num[i] = String.valueOf(num[i]);
    }
    Arrays.sort(s_num, comp);
    if (s_num[0].charAt(0) == '0')
        return "0";
    StringBuilder sb = new StringBuilder();
    for (String str: s_num) {
        sb.append(str);
    }
    return sb.toString();
}
