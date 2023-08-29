class Solution {
    public List<List<Integer>> getFactors(int n) {
        if (n < 2) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(res, 2, n, tmp);
        return res;
    }

    private void dfs(List<List<Integer>> res, int index, int n, List<Integer> tmp) {
        if (n == 1) {
            if (tmp.size() > 1) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        for (int i = index; i <= n; i++) {
            if (n % i != 0) {
                continue;
            }

            tmp.add(i);
            dfs(res, i, n / i, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

public class LC_254_FactorCombinations {

}
