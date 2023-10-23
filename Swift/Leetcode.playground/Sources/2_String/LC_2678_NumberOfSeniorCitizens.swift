class Solution {
    func countSeniors(_ details: [String]) -> Int {
        var count = 0
        for info in details {
            let index1 = info.index(info.startIndex, offsetBy: 11) 
            let index2 = info.index(info.startIndex, offsetBy: 12) 
            if let age = Int(info[index1...index2]), age > 60 {
                count += 1
            }
        }
        return count
    }
}