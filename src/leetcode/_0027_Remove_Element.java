package leetcode;

/**
 * Created by kimvra on 2019-03-06
 */
public class _0027_Remove_Element {
    public int removeElement(int[] nums, int val) {
        int tail = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }
}
