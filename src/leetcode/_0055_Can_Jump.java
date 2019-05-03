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
}
