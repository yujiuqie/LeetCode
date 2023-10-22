class Solution {
    func maxSatisfaction(_ satisfaction: [Int]) -> Int {
        let n = satisfaction.count
        var dp = [[Int]](repeating:[Int](repeating:0, count: n + 1), count: n + 1)
        var sort_satis = satisfaction
        sort_satis.sort()
        var res = 0
        for i in 1...n{
            for j in 1...i{
                dp[i][j] = dp[i - 1][j - 1] + sort_satis[i - 1] * j
                if j < i{
                    dp[i][j] = max(dp[i - 1][j],dp[i][j])
                }

                res = max(res,dp[i][j])
            }
        }

        return res
    }
}