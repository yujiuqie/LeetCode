class Solution {
    public int passThePillow(int n, int time) {
        int round = 2 * (n - 1);
        int step = time % round;
        return (step < n ? step : round - step) + 1;
    }
}

public class LC_2582_PassThePillow {

}
