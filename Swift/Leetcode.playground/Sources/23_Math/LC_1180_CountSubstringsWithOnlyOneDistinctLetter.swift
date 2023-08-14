import Cocoa

public class Solution_1180 {
    public func countLetters(_ s: String) -> Int {
        var res : Int = 0
        var count : Int = 1
        for i in 1..<s.count{
            if(s[s.index(s.startIndex, offsetBy: i)] == s[s.index(s.startIndex, offsetBy: i - 1)]){
                count += 1
            }
            else{
                res += count * (count + 1) / 2
                count = 1
            }
        }
        res += count * (count + 1) / 2
        return res
    }
}

public class LC_1180_CountSubstringsWithOnlyOneDistinctLetter : Solution_1180 {
    public override init() {}
}
