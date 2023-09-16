class Solution {
    public int minimumEffortPath(int[][] mat) {

        // 把输入的矩阵转化成为每条边都带有权重的图
        // 寻找从最左上角到最右下角的最小体力消耗路径

        int M = mat.length;
        int N = mat[0].length;

        // edges[i] 是个 [边的权重，边的第一个顶点，边的第二个顶点] 三元组
        List<int[]> edges = new ArrayList<>();

        // 生成所有的边，并保存到 edges 中
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                // 把二维左边转成了一维，即第 i 行第 j 列映射成了 i * N +
                // j。因为实现并查集时使用的数组结构，因此需要把每个节点的二维坐标映射成该数组中的具体位置。这是一个在解决数组问题中的技巧。
                int pos = i * N + j;

                if (j + 1 < N) {
                    edges.add(new int[] {
                            Math.abs(mat[i][j + 1] - mat[i][j]), // 边的权重 - 两点值相减
                            pos, // 边的第一个顶点
                            pos + 1 // 边的第二个顶点
                    });
                }
                if (i + 1 < M) {
                    edges.add(new int[] {
                            Math.abs(mat[i + 1][j] - mat[i][j]), // 边的权重 - 两点值相减
                            pos, // 边的第一个顶点
                            pos + N // 边的第二个顶点
                    });
                }
            }
        }

        // 按权重排序，以便于优先寻找最小权重边
        Collections.sort(edges, (o1, o2) -> o1[0] - o2[0]);

        // 并查集的作用就是判断最左上角和最右下角是否连通，以及当每次添加上一条新的边时，若该边属于两个未联通的区域，则把两个区域连通起来。
        UnionFind uf = new UnionFind(M * N);

        // 遍历所有边
        for (int[] edge : edges) {

            // 连通这个边的两个节点
            uf.union(edge[1], edge[2]);

            // 判断最左上角和最右下角两个节点是否连通了。
            // 如果已经连通，则此时的边的权重就是我们要求的最小体力消耗值
            if (uf.find(0) == uf.find(M * N - 1)) {
                return edge[0];
            }
        }

        return 0;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int N) {
            this.parent = new int[N];
            this.rank = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i; // 父节点指针初始指向自己
            }
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

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }
    }
}

public class LC_1631_PathWithMinimumEffort {

}
