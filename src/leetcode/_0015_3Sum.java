package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kimvra on 2019-03-01
 */
public class _0015_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return lists;
        }
        Arrays.sort(nums);
        int max = nums[len - 1];
        if (max < 0) {
            return lists;
        }
        for (int i = 0; i < len - 2;) {
            if (nums[i] > 0) {
                break;
            }
            if (nums[i] + 2 * max < 0) {
                while (nums[i] == nums[++i] && i < len - 2);
                continue;
            }
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (nums[left] == nums[++left] && left < right);
                    while (nums[right] == nums[--right] && left < right);
                } else if (sum > 0) {
                    --right;
                } else {
                    ++left;
                }
            }
            while (nums[i] == nums[++i] && i < len - 2);
        }
        return lists;
    }


}
