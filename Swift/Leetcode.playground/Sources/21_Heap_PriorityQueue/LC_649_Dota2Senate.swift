class Solution {
    func predictPartyVictory(_ senate: String) -> String {
        var rd = [Int]()
        var dd = [Int]()
        let n = senate.count
        for (i, char) in senate.enumerated() {
            if char == "R" {
                rd.append(i)
            } else {
                dd.append(i)
            }
        }
        while !rd.isEmpty && !dd.isEmpty {
            let a = rd.removeFirst()
            let b = dd.removeFirst()
            if a < b {
                rd.append(a + n)
            } else {
                dd.append(b + n)
            }
        }
        return !rd.isEmpty ? "Radiant" : "Dire"
    }
}