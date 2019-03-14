public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    backTrack(res, new ArrayList<>(), n, k, 1);
    return res;
}

private void backTrack(List<List<Integer>> res, List<Integer> tempList, int n, int k, int begin) {
    if (k == 0) {
        res.add(new ArrayList<>(tempList));
        return ;
    }
    for (int i = begin; i <= n; i++) {
        tempList.add(i);
        backTrack(res, tempList, n, k-1, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}
