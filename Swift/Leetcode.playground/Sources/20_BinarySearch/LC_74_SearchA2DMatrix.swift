class Solution {
    func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
        let m = matrix.count
        let n = matrix[0].count
        var left = 0
        var right = m * n - 1
        while left <= right {
            let mid = (left + right + 1) >> 1
            let mid_num = matrix[mid / n][mid % n]
            if mid_num < target {
                left = mid + 1
            } else if mid_num > target {
                right = mid - 1
            } else {
                return true
            }
        }
        return false
    }
}