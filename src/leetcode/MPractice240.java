package leetcode;

/**
 * Created by kimvra on 2019-03-14
 */
public class MPractice240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = rows - 1, c = 0;
        while (r >= 0 && r < rows && c >= 0 && c < cols) {
            if (target > matrix[r][c]) {
                ++c;
            } else if (target < matrix[r][c]) {
                --r;
            } else {
                return true;
            }
        }
        return false;
    }
}
