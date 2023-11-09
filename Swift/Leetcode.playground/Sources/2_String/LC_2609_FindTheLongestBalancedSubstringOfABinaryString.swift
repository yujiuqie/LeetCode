class Solution {
    func findTheLongestBalancedSubstring(_ s: String) -> Int {
        let n = s.count
        var idx = 0
        var ans = 0
        while idx < n {
            var a = 0
            var b = 0
            while idx < n && s[s.index(s.startIndex, offsetBy: idx)] == "0" {
                a += 1
                idx += 1
            }
            while idx < n && s[s.index(s.startIndex, offsetBy: idx)] == "1" {
                b += 1
                idx += 1
            }
            ans = max(ans, min(a, b) * 2)
        }
        return ans
    }
}

