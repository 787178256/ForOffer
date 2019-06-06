package leetcode;

/**
 * Created by kimvra on 2019-06-05
 */
public class _0084_Largest_Rectangle_Area {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            int rightIndex = i, leftIndex = i;
            while (rightIndex < len && heights[rightIndex] >= heights[i]) {
                ++rightIndex;
            }
            while (leftIndex >= 0 && heights[leftIndex] >= heights[i]) {
                --leftIndex;
            }
            right[i] = rightIndex - i - 1;
            left[i] = i - leftIndex - 1;
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            maxArea = Math.max(maxArea, (left[i] + right[i] + 1) * heights[i]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
