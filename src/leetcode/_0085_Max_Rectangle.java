package leetcode;

import java.util.Stack;

/**
 * Created by kimvra on 2019-06-17
 * 给定一个仅包含0和1的二维二进制矩阵，找出只包含1的最大矩形，并返回其面积
 */
public class _0085_Max_Rectangle {
    private static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[] cur = new int[col];
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cur[j] = matrix[i][j] == '1' ? cur[j] + 1 : 0;
                while (stack.peek() != -1 && cur[stack.peek()] > cur[j]) {
                    ret = Math.max(cur[stack.pop()] * (j - stack.peek() - 1), ret);
                }
                stack.push(j);
            }
            while (stack.peek() != -1) {
                ret = Math.max(cur[stack.pop()] * (col - stack.peek() - 1), ret);
            }
        }
        return ret;
    }
}
