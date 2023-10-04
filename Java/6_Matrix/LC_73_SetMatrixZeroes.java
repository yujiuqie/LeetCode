class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flag_row_0 = false;
        boolean flag_col_0 = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                flag_row_0 = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                flag_col_0 = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 置零，2部分
        for (int i = 1; i < matrix.length; ++i) {// 行置零
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; ++j) {// 列置零
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flag_row_0 == true) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[0][j] = 0;
            }
        }

        if (flag_col_0 == true) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}

public class LC_73_SetMatrixZeroes {

}
