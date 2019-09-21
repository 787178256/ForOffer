package leetcode;

import java.util.Arrays;

/**
 * Created by kimvra on 2019-03-02
 */
public class _0016_3Sum_Closest {
    public  static int betterSolution(int[] nums, int target) {
        int len = nums.length;
        int delta = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int curDelta = Math.abs(sum - target);
                if (curDelta == 0) {
                    return sum;
                }
                if (curDelta < delta) {
                    delta = curDelta;
                    res = sum;
                }
                if (sum > target) {
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,1,55};
        int target = 3;
        System.out.println(betterSolution(nums, target));
    }
}
