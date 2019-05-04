package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-05-04
 */
public class _0054_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        recursive(nums, 0, nums.length - 1, nums[0].length - 1, result);
        return result;
    }

    private void recursive(int[][] matrix, int start, int rowEnd, int colEnd, List<Integer> res) {

        if (start > rowEnd || start > colEnd) {
            return;
        }
        /*
         * 遍历到只剩下1x1的矩阵时
         */
        if (start == rowEnd && start == colEnd) {
            res.add(matrix[start][start]);
            return;
        }

        /*
         * 遍历矩阵最上面一行，但不包括最后一个元素，这个元素要放着给下一个循环遍历
         */
        for (int i = 0; i < colEnd - start; i++) {
            res.add(matrix[start][start + i]);
        }
        /*
         * 遍历矩阵最右边一行，但不包括最下面一个元素。
         */
        for (int j = 0; j < rowEnd - start; j++) {
            res.add(matrix[start + j][colEnd]);
        }
        /*
         * 对于只有一行或一列的矩阵，把前面遍历剩下的最后一个元素加进来
         *      {1,  2,  3,  4},
         *      {5,  6,  7,  8},
         *      {9, 10, 11, 12}
         * 这里用来加7这个元素
         */
        if (start == colEnd || start == rowEnd) {
            res.add(matrix[rowEnd][colEnd]);
        }
        /*
         * 为什么会有 start < rowEnd, 避免只有一行的矩阵在第一个循环里面遍历之后，在这里再遍
         * 历一次
         */
        for (int k = 0; k < colEnd - start && start < rowEnd; k++) {
            res.add(matrix[rowEnd][colEnd - k]);
        }
        for (int l = 0; l < rowEnd - start && start < colEnd; l++) {
            res.add(matrix[rowEnd - l][start]);
        }

        recursive(matrix, start + 1, rowEnd - 1, colEnd - 1, res);
    }

}
