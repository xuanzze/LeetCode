class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] roots = new int[edges.length];
        for (int i = 0; i < edges.length; i++) roots[i] = i;

        int[] candidate1 = null, candidate2 = null;
        for (int[] e : edges){
            int rootx = find(roots, e[0]-1), rooty = find(roots, e[1]-1);
            if (rootx != rooty) {
                if (rooty != e[1]-1) candidate1 = e; // record the last edge which results in "multiple parents" issue
                else roots[rooty] = rootx;
            }
            else candidate2 = e; // record last edge which results in "cycle" issue, if any.
        }

        // if there is only one issue, return this one.
        if (candidate1 == null) return candidate2; 
        if (candidate2 == null) return candidate1;
        
        // If both issues present, then the answer should be the first edge which results in "multiple parents" issue
        // Could use map to skip this pass, but will use more memory.
        for (int[] e : edges) if (e[1] == candidate1[1]) return e;

        return new int[2];
    }

    private int find(int[] roots, int i){
        while (i != roots[i]){
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }
}
