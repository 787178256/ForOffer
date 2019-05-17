package leetcode;

/**
 * Created by kimvra on 2019-05-03
 */
public class _0055_Can_Jump {
    public static boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n ++;
            }
            if (i == 0 && n > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean reviewSolution(int[] nums) {
        int len = nums.length;
        int step = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] >= step) {
                step = 1;
            } else {
                step++;
            }
            if (i == 0 && nums[0] < step) {
                return false;
            }
        }
        return true;
    }
}
