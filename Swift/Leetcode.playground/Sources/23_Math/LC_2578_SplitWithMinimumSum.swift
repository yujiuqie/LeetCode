class Solution {
    func splitNum(_ num: Int) -> Int {
        let cs = Array(String(num))
        let sortedCs = cs.sorted()
        var a = [Int](repeating: 0, count: 2)
        for i in 0..<sortedCs.count {
            a[i % 2] = a[i % 2] * 10 + Int(String(sortedCs[i]))!
        }
        return a[0] + a[1]
    }
}