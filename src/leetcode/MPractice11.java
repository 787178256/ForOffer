package leetcode;


/**
 * Created by kimvra on 2019-03-01
 */
public class MPractice11 {
    public static int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((j - i) * Math.min(height[j], height[i]) > maxArea) {
                    maxArea = (j - i) * Math.min(height[j], height[i]);
                }
            }
        }
        return maxArea;
    }

    public static int betterSolution(int[] height) {
        int start = 0, end = height.length - 1, maxArea = 0, h;
        while (start < end) {
            h = Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, h * (end - start));
            while (height[start] <= h && start < end) {
                start++;
            }
            while (height[end] <= h && start < end) {
                end--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
