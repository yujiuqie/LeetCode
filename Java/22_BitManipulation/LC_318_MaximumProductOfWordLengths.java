class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            int t = 0, m = w.length();
            for (int i = 0; i < m; i++) {
                int u = w.charAt(i) - 'a';
                //使用 Int 低 26 位表示一个纯小写字母组成的字符串
                t |= (1 << u);
            }
            if (!map.containsKey(t) || map.get(t) < m)
                map.put(t, m);
        }
        int ans = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                //如果两个 Int 每一个二进制位都不同，则他们所代表的字符串必然不相等
                if ((a & b) == 0)
                    ans = Math.max(ans, map.get(a) * map.get(b));
            }
        }
        return ans;
    }
}

public class LC_318_MaximumProductOfWordLengths {

}
