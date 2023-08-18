class Solution {
    public int numWays(int n, int k) {
         if(n == 1){
             return k;
         }

         if(n == 2){
             return k * k;
         }

         int[] dp = new int[n];
         dp[0] = k; //一根栅栏时共 k 种可选
         dp[1] = k * k; //两根栅栏时每一根都可以选 k 种
         for(int i = 2; i < n; i++){
             //情况一：第 i 个与第 i - 1 个栅栏不同色，共 （k - 1） * dp[i - 1] 个可选
             //情况二：第 i 个与第 i - 1 个栅栏同色，则要求 i - 1 与 i - 2 个栅栏不同色，此时共（k - 1） * dp[i - 2] 个可选
             dp[i] = (k - 1) * dp[i - 1] + (k - 1) * dp[i - 2];
         }

         return dp[n - 1];
    }
}