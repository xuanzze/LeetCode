public List<List<Integer>> subsetsWithDup(int[] num) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> empty = new ArrayList<Integer>();
    result.add(empty);
    Arrays.sort(num);

    for (int i = 0; i < num.length; i++) {
        int dupCount = 0;
        while (((i + 1) < num.length) && num[i + 1] == num[i]) {
            dupCount++;
            i++;
        }
        int prevNum = result.size();
        for (int j = 0; j < prevNum; j++) {
            List<Integer> element = new ArrayList<Integer>(result.get(j));
            for (int t = 0; t <= dupCount; t++) {   // 这里是小于等于，至少有一次添加
                element.add(num[i]);
                result.add(new ArrayList<Integer>(element));
            }
        }
    }
    return result;
}
