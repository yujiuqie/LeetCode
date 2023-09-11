class Solution {
    public int largestAltitude(int[] g) {
        int cur = 0, ans = 0;
        for (int x : g) {
            cur += x;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}

public class LC_1732_FindTheHighestAltitude {

}
