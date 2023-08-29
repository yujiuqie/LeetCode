class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long MOD = (long) 1e9 + 7;

        // 排序是为了递归时只需要遍历小于当前查找值的数
        Arrays.sort(arr);

        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i); // 使用字典便于寻找另一个因子的位置
        }

        long[] memo = new long[n]; // 记忆化搜索减少递归次数
        Arrays.fill(memo, -1);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dfs(i, arr, memo, map);
        }
        return (int) (ans % MOD);
    }

    private long dfs(int i, int[] arr, long[] memo, Map<Integer, Integer> map) {
        if (memo[i] != -1) {
            return memo[i];
        }

        int val = arr[i]; // 本地递归需要查找的根节点
        long res = 1; // 默认为 1（不含因子的单独根同样可以作为树）
        for (int j = 0; j < i; j++) {
            int x = arr[j];

            // 两个因子：
            // 1. x : 满足条件是 val % x == 0
            // 2. val / x : 满足条件是该值必须在字典 key 中（在原 arr 数组中）
            if (val % x == 0 && map.containsKey(val / x)) {
                res += dfs(j, arr, memo, map) * dfs(map.get(val / x), arr, memo, map);
            }
        }

        return memo[i] = res;
    }
}

public class LC_823_BinaryTreesWithFactors {

}
