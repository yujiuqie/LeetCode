class Solution {
    func findTheArrayConcVal(_ nums: [Int]) -> Int {
        var left = 0
        var right = nums.count - 1
        var sum = 0
        var sb: String
        while left < right {
            sb = ""
            sb.append(String(nums[left]))
            sb.append(String(nums[right]))
            sum += Int(sb)!
            left += 1
            right -= 1
        }
        sum += left == right ? nums[left] : 0
        return sum
    }
}