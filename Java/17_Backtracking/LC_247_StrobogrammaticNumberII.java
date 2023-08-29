class Solution {
    public List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }

    private List<String> dfs(int n, int m) {
        if (n < 0 || m < 0 || n > m) {
            return new ArrayList<>();
        }

        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }

        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        List<String> list = dfs(n - 2, m);

        List<String> res = new ArrayList<>();

        for (String s : list) {
            if (n != m) {
                res.add("0" + s + "0");
            }

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }
}