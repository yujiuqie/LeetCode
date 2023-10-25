class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dfs(i * i, i))
                ans += i * i;
        }
        return ans;
    }

    boolean dfs(int t, int x) {
        if (t == x)
            return true;
        int d = 10;
        while (t >= d && t % d <= x) {
            if (dfs(t / d, x - (t % d)))
                return true;
            d *= 10;
        }
        return false;
    }
}

public class LC_2698_FindThePunishmentNumberOfAnInteger {

}
