class Solution {
    func maxArea(_ h: Int, _ w: Int, _ horizontalCuts: [Int], _ verticalCuts: [Int]) -> Int {
        let sortedHorizontalCuts = horizontalCuts.sorted()
        let sortedVerticalCuts = verticalCuts.sorted()
        return Int((Int64(calMax(sortedHorizontalCuts, h)) * Int64(calMax(sortedVerticalCuts, w))) % 1000000007)
    }
    
    func calMax(_ arr: [Int], _ boardr: Int) -> Int {
        var res = 0
        var pre = 0
        for i in arr {
            res = max(i - pre, res)
            pre = i
        }
        return max(res, boardr - pre)
    }
}
