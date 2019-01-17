public int[] findOrder(int numCourses, int[][] prerequisites) {
    ArrayList<Integer>[] graph = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++)
        graph[i] = new ArrayList<>();
    for (int i = 0; i < prerequisites.length; i++)
        graph[prerequisites[i][0]].add(prerequisites[i][1]);
    boolean[] onpath = new boolean[numCourses];
    boolean[] visit = new boolean[numCourses];
    ArrayList<Integer> order = new ArrayList<>();
    for (int i = 0; i < numCourses; i++)
        if (!visit[i] && ! dfs_find_cycle(graph, i, order, visit, onpath))
            return new int[0];
    int[] res = new int[numCourses];
    for (int i = 0; i < numCourses; i++)
        res[i] = (int) order.get(i);
    return res;
}

private boolean dfs_find_cycle(ArrayList<Integer>[] graph, int idx, ArrayList<Integer> order, boolean[] visit, boolean[] onpath) {
    if (visit[idx])
        return true;
    visit[idx] = onpath[idx] = true;
    for (int i = 0; i < graph[idx].size(); i++)
        if (onpath[(int) graph[idx].get(i)] || ! dfs_find_cycle(graph, (int)graph[idx].get(i), order, visit, onpath))
            return false;
    onpath[idx] = false;
    order.add(idx);
    return true;
}
