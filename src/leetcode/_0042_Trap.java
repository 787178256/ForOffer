package leetcode;

/**
 * Created by kimvra on 2019-05-27
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水)
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class _0042_Trap {
    public static int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len]; // left[i]表示i左边最高的高度
        int[] right = new int[len]; // right[i]表示i右边最高的高度
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int h = Math.min(left[i], right[i]);
            sum += Math.max(0, h - height[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
