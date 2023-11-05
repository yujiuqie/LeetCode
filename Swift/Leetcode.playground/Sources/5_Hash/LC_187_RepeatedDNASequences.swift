class Solution {
    func findRepeatedDnaSequences(_ s: String) -> [String] {
        var ans = [String]()
        let n = s.count
        if n < 10{
            return ans
        }
        var map = [String: Int64]()
        for i in 0...(n - 10) {
            let start = s.index(s.startIndex, offsetBy: i)
            let end = s.index(s.startIndex, offsetBy: i + 10)
            let cur = String(s[start..<end])
            let cnt = map[cur, default: 0]
            if cnt == 1 {
                ans.append(cur)
            }
            map[cur] = cnt + 1
        }
        return ans
    }
}