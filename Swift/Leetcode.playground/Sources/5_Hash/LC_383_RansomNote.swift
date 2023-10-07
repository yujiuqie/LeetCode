class Solution {
    func canConstruct(_ ransomNote: String, _ magazine: String) -> Bool {
        if ransomNote.count > magazine.count {
            return false
        }
        var cnt = Array(repeating: 0, count: 26)
        let index = Character("a").asciiValue!
        for c in magazine {
            cnt[Int(c.asciiValue! - index)] += 1
        }
        for c in ransomNote {
            cnt[Int(c.asciiValue! - index)] -= 1
            if cnt[Int(c.asciiValue! - index)] < 0 {
                return false
            }
        }
        return true
    }
}