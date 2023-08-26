class Solution {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int landIndex = i * n + j;
                if (grid[i][j] == '1') {
                    // 合并右侧
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        uf.union(landIndex, landIndex + 1);
                    }
                    // 合并下侧
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        uf.union(landIndex, landIndex + n);
                    }
                }
            }
        }

        return uf.size();
    }
}

// 并查集 Union-Find-Set,能实现O(1)时间复杂度进行 合并合集、查找集合
class UnionFind {

    // parent[i]用于存储i指向的父亲节点，一直递归能找到所在集合的代表节点（根）
    private int[] parent;

    // rank[i]用于存储以i为根节点的树的高度上界（rank)
    private int[] rank;

    private int landCount = 0;
    private int unionCount = 0;

    // 构造函数
    public UnionFind(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        parent = new int[m * n];
        rank = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    landCount++;
                    parent[i * n + j] = i * n + j;
                    rank[i * n + j] = 1;
                }
            }
        }
    }

    // 带路径压缩的查找
    // 路径压缩，让集合从链状指向变成菊花指向（链状树 压缩成 放射状菊花树）
    public int find(int x) {

        // 递归终止，只有根节点才指向自己
        if (parent[x] == x) {
            return x;
        }

        // find递归返回根节点，让查找过程中每一个x以及x的父节点等直接指向根节点
        return parent[x] = find(parent[x]);
    }

    // 按秩(高度)求并
    // 合并x,y所在集合
    public void union(int x, int y) {

        // 合并根节点
        int xRoot = find(x);
        int yRoot = find(y);

        // 本身就在一个集合就不用合并
        if (xRoot != yRoot) {

            // 元素合并次数，每合并一次就++，方便统计集合个数（=元素总数-合并次数）
            unionCount++;

            if (rank[yRoot] <= rank[xRoot]) { // x 树更高或相等高度
                parent[yRoot] = xRoot; // y 根指向 x 根
            } else { // y 树更高或相等高度
                parent[xRoot] = yRoot; // x 根指向 y 根
            }

            // 两树高度相等，合并后新树高度+1
            if (rank[xRoot] == rank[yRoot]) {
                rank[xRoot]++;
            }
        }
    }

    // 集合个数
    public int size() {
        return landCount - unionCount; // 每合并一次，unionCount++，方便最后集合个数=总元素个数-合并次数。集合个数也可以通过find访问所有元素获得的不同根节点的个数来确定。
    }
}