class Solution {
    func deleteAndEarn(_ nums: [Int]) -> Int {
        var map = [Int: Int]()
        var max_num = nums[0]
        for num in nums {
            map[num, default: 0] += 1
            max_num = max(max_num, num)
        }

        if max_num < 2 {
            return map[max_num, default: 0]
        }

        var dp = Array(repeating: 0, count: max_num + 1)
        dp[1] = map[1, default: 0] * 1
        for i in 2...max_num {
            dp[i] = max(dp[i - 1], dp[i - 2] + i * map[i, default: 0])
        }
        return dp[max_num]
    }
}