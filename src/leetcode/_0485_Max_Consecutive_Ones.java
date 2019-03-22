package leetcode;

/**
 * Created by kimvra on 2019-03-14
 */
public class _0485_Max_Consecutive_Ones {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len;) {
            int count = 0;
            if (nums[i] != 1) {
                i++;
                continue;
            }
            while (i < len && nums[i] == 1) {
                i++;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static int findMaxConsecutiveOnes1(int[] nums) {
        int cur = 0, max = 0;
        for (int num : nums) {
            cur = num == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
