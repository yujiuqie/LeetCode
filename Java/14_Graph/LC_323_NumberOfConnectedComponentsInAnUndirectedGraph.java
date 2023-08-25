class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        UnionFind uf = new UnionFind(parent);
        int ucount = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (uf.find(u) != uf.find(v)) {
                uf.union(u, v);
                ucount++;
            }
        }

        return n - ucount;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int[] parent) {
        this.parent = parent;
        this.rank = new int[parent.length];
        Arrays.fill(rank, 1);
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (rank[yRoot] <= rank[xRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[xRoot] = yRoot;
        }

        if (rank[xRoot] == rank[yRoot]) {
            rank[xRoot]++;
        }
    }
}

public class LC_323_NumberOfConnectedComponentsInAnUndirectedGraph {

}
