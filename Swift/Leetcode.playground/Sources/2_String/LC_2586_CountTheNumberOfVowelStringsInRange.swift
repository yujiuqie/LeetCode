class Solution {
    func vowelStrings(_ words: [String], _ left: Int, _ right: Int) -> Int {
        var ans = 0
        for i in left...right {
            let s = words[i]
            let a = s.first!
            if !"aeiou".contains(a) {
                continue
            }
            let b = s.last!
            if "aeiou".contains(b) {
                ans += 1
            }
        }
        return ans
    }
}

