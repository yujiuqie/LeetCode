class Solution {
    func singleNumber(_ nums: [Int]) -> Int {
        var res = 0
        for num in nums{
            res ^= num
        }

        return res
    }
}