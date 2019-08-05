package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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

    // 单调栈
    private int maximalRectangleWithStack(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[] nums = new int[row];
        int maxArea = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[j][i] == '1') {
                    nums[j] += 1;
                } else {
                    nums[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, maxRectangle(nums));
        }
        return maxArea;
    }

    private int maxRectangle(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.add(-1);
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < list.size(); i++) {
            if (stack.isEmpty() || list.get(i) >= list.get(stack.peek())) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && list.get(stack.peek()) > list.get(i)) {
                int lastIndex = stack.pop();
                maxArea = Math.max(list.get(lastIndex) * (stack.isEmpty() ? i : i - stack.peek() - 1), maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }

    @Test
    public void test() {
        char[][] matrix = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        char[][] m = {{'0','1'},{'1','0'}};
        System.out.println(maximalRectangleWithStack(m));
    }
}
