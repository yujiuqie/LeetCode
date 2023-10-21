class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] item : edges) {
            g.get(item[0]).add(item[1]);
            g.get(item[1]).add(item[0]);
        }
        boolean[] vis = new boolean[n];
        long ans = 0, total = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int size = dfs(i, g, vis);
                ans += size * total;
                total += size;
            }
        }
        return ans;
    }

    private int dfs(int x, List<List<Integer>> g, boolean[] vis) {
        vis[x] = true;
        int size = 1;
        for (int item : g.get(x)) {
            if (!vis[item]) {
                size += dfs(item, g, vis);
            }
        }
        return size;
    }
}