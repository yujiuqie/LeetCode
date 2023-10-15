class Solution {
    func singleNumber(_ nums: [Int]) -> Int {
        let sortedNums = nums.sorted()
        for i in stride(from: 0, to: nums.count - 3, by: 3) {
            if sortedNums[i] != sortedNums[i + 2] {
                return sortedNums[i]
            }
        }
        return sortedNums[nums.count - 1]
    }
}