package leetcode;

/**
 * Created by kimvra on 2019-03-14
 */
public class _0566_Matrix_Reshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;
        if (r * c != rows * cols) {
            return nums;
        }
        int index = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[index / cols][index % cols];
                index++;
            }
        }
        return res;
    }
}
