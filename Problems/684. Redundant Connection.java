public int[] findRedundantConnection(int[][] edges) {  
        UnionFind unionFind = new UnionFind(edges.length);
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!unionFind.union(u, v)) {
                return edge;
            }
        }
    
        throw null;
    }
    
    class UnionFind {
        private int[] parent; 
        private int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        private int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }
        
        private boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX == rootY)
                return false;
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];
            } else {
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];
            }
            return true;
        }
    }
