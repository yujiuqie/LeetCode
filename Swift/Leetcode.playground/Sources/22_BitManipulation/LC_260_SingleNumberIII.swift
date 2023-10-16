class Solution {
    func singleNumber(_ nums: [Int]) -> [Int] {
        var sum = 0
        for num in nums {
            sum ^= num
        }
        let lbs = sum & (-sum)
        var num1 = 0
        var num2 = 0
        for num in nums {
            if (num & lbs) != 0 {
                num1 ^= num
            } else {
                num2 ^= num
            }
        }
        return [num1, num2]
    }
}