package leetcode;

/**
 * Created by kimvra on 2019-05-04
 */
public class _0059_Generate_Matrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int c = 1, j = 0;
        while (c <= n * n) {
            for (int i = j; i < n - j; i++) {
                matrix[j][i] = c++;
            }
            for (int i = j + 1; i < n - j; i++) {
                matrix[i][n - j - 1] = c++;
            }
            for (int i = n - j - 2; i >= j; i--) {
                matrix[n - j - 1][i] = c++;
            }
            for (int i = n - j - 2; i > j; i--) {
                matrix[i][j] = c++;
            }
            j++;
        }
        return matrix;
    }
}
