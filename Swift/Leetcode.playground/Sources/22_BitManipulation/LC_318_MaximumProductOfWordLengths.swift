class Solution {
    func maxProduct(_ words: [String]) -> Int {
        var map = [Int: Int]()
        for w in words {
            var t = 0, m = w.count
            for i in 0..<m {
                let u = w[w.index(w.startIndex, offsetBy: i)].asciiValue! - Character("a").asciiValue!
                t |= (1 << u)
            }
            if map[t] == nil || map[t]! < m {
                map[t] = m
            }
        }
        var ans = 0
        for a in map.keys {
            for b in map.keys {
                if (a & b) == 0 {
                    ans = max(ans, map[a]! * map[b]!)
                }
            }
        }
        return ans
    }
}

