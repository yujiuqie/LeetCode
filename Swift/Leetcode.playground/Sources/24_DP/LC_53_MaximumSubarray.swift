class Solution {
    func maxSubArray(_ nums: [Int]) -> Int {
        let n = nums.count
        var res = nums[0]
        var pre = 0
        for i in 0..<n {
            pre = max(pre + nums[i],nums[i])
            res = max(pre,res);
        } 
        return res;
    }
}