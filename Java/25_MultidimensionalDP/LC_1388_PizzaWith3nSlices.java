import java.util.*;

class Solution {
    public int maxSizeSlices(int[] slices) {
        int len = slices.length;
        int[] v1 = new int[len - 1];
        int[] v2 = new int[len - 1];

        for(int i = 0; i < len - 1; i++){
            v1[i] = slices[i];
        }

        for(int i = 1; i < len; i++){
            v2[i - 1] = slices[i];
        }

        int res1 = caculate(v1);
        int res2 = caculate(v2);

        return Math.max(res1,res2);
    }

    private int caculate(int[] slices){
        int len = slices.length;
        int n = (len + 1) / 3;

        // dp[i][j] 表示在前 i 个数中选择了 j 个不相邻的数的最大和
        int[][] dp = new int[len][n + 1];

        for(int i = 0; i < len; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        dp[0][0] = 0;   //在 1 块披萨中选择不拿
        dp[0][1] = slices[0]; //在 1 块披萨中选择拿 1 块
        dp[1][0] = 0;  //在 2 块披萨中选择不拿
        dp[1][1] = Math.max(slices[0],slices[1]); //在 2 块披萨中选择拿 1 块

        for(int i = 2; i < len; i++){
            dp[i][0] = 0; //在 i 块披萨中选择不拿

            //在 i 块披萨中选择拿 1~n 块
            for(int j = 1; j <= n; j++){
                //情况一：没有选择第 i 个数，那么需要在前 i−1 个数中选择 j 个，即 dp[i][j]=dp[i−1][j]。
                //情况二：选择了第 i 个数，那么第 i−1 个数不能被选择，相当于需要在前 i−2 个数中选择 j−1 个，即 dp[i][j]=dp[i−2][j−1]+slices[i]。
                //dp[i][j] 为以上两种情况中的最大值
                dp[i][j] = Math.max(dp[i - 1][j],dp[i - 2][j - 1] + slices[i]);
            }
        }

        return dp[len - 1][n];
    }
}