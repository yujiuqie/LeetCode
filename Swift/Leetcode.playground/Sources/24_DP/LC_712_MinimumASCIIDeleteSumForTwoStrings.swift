class Solution {
    func minimumDeleteSum(_ s1: String, _ s2: String) -> Int {
        let m = s1.count
        let n = s2.count
        var dp = [[Int]](repeating: [Int](repeating: 0, count: n + 1), count: m + 1)
        
        for i in 1...m {
            dp[i][0] = dp[i - 1][0] + Int(s1[s1.index(s1.startIndex, offsetBy: i - 1)].asciiValue!)
        }
        
        for j in 1...n {
            dp[0][j] = dp[0][j - 1] + Int(s2[s2.index(s2.startIndex, offsetBy: j - 1)].asciiValue!)
        }
        
        for i in 1...m {
            let code1 = Int(s1[s1.index(s1.startIndex, offsetBy: i - 1)].asciiValue!)
            for j in 1...n {
                let code2 = Int(s2[s2.index(s2.startIndex, offsetBy: j - 1)].asciiValue!)
                if code1 == code2 {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = min(dp[i - 1][j] + code1, dp[i][j - 1] + code2)
                }
            }
        }
        
        return dp[m][n]
    }
}