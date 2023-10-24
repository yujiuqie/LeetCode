class Solution {
    func findTheDifference(_ s: String, _ t: String) -> Character {
        var asciiValue: UInt8 = 0
        for c in s { asciiValue ^= c.asciiValue! }
        for c in t { asciiValue ^= c.asciiValue! }
        return Character(UnicodeScalar(asciiValue))
    }
}