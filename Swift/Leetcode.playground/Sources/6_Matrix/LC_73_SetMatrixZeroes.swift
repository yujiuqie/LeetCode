class Solution {
    func setZeroes(_ matrix: inout [[Int]]) {
        var flag_row_0 = false
        var flag_col_0 = false
        for i in 0..<matrix[0].count {
            if matrix[0][i] == 0 {
                flag_row_0 = true
            }
        }
        for i in 0..<matrix.count {
            if matrix[i][0] == 0 {
                flag_col_0 = true
            }
        }
        for i in 1..<matrix.count {
            for j in 1..<matrix[0].count {
                if matrix[i][j] == 0 {
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }
        
        for i in 1..<matrix.count {
            if matrix[i][0] == 0 {
                for j in 0..<matrix[0].count {
                    matrix[i][j] = 0
                }
            }
        }
        for j in 1..<matrix[0].count {
            if matrix[0][j] == 0 {
                for i in 0..<matrix.count {
                    matrix[i][j] = 0
                }
            }
        }
        if flag_row_0 == true {
            for j in 0..<matrix[0].count {
                matrix[0][j] = 0
            }
        }
        if flag_col_0 == true {
            for i in 0..<matrix.count {
                matrix[i][0] = 0
            }
        }
    }
}