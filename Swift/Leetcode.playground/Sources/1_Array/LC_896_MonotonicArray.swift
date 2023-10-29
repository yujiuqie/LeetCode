class Solution {
    func isMonotonic(_ nums: [Int]) -> Bool {
        var inc = true, dec = true
        let n = nums.count
        for i in 0..<n-1 {
            if nums[i] > nums[i+1] {
                inc = false
            }
            if nums[i] < nums[i+1] {
                dec = false
            }
        }
        return inc || dec
    }
}