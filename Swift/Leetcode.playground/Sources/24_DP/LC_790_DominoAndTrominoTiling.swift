class Solution {
    private let MOD: Int64 = 1_000_000_007
    
    func numTilings(_ n: Int) -> Int {
        
        var dp = [Int](repeating: 0, count: 1001)
        dp[0] = 1
        dp[1] = 1
        dp[2] = 2
        
        if n > 2{
            for i in 3...n {
                dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007
            }
        }
        
        return dp[n]
    }
}