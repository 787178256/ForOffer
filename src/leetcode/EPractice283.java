package leetcode;

/**
 * Created by kimvra on 2019-03-14
 */
public class EPractice283 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
