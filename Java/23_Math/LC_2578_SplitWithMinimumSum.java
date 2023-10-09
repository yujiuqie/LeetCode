class Solution {
    public int splitNum(int num) {
        char[] cs = Integer.toString(num).toCharArray();
        Arrays.sort(cs);
        int[] a = new int[2];
        for (int i = 0; i < cs.length; i++) {
            a[i % 2] = a[i % 2] * 10 + cs[i] - '0';
        }
        return a[0] + a[1];
    }
}

public class LC_2578_SplitWithMinimumSum {

}
