package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kimvra on 2019-03-02
 */
public class _0018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return res;
        }
        Arrays.sort(nums);
        int max = nums[len - 1];
        if (4 * max < target) {
            return res;
        }
        for (int i = 0; i < len - 3;) {
            if (nums[i] * 4 > target) {
                break;
            }
            if (nums[i] + 3 * max < target) {
                while (nums[i] == nums[++i] && i < len - 3);
                continue;
            }
            for (int j = i + 1; j < len - 2;) {
                int subSum = nums[i] + nums[j];
                if (nums[i] + nums[j] * 3 > target) {
                    break;
                }
                if (subSum + 2 * max < target) {
                    while (nums[j] == nums[++j] && j < len -2);
                    continue;
                }

                int left = j + 1, right = len - 1;
                while (left < right) {
                    int sum = subSum + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (nums[left] == nums[++left] && left < right);
                        while (nums[right] == nums[--right] && left < right);
                    } else if (sum < target) {
                        ++left;
                    } else {
                        --right;
                    }
                }
                while (nums[j] == nums[++j] && j < len - 2);
            }
            while (nums[i] == nums[++i] && i < len - 3);
        }
        return res;
    }
}
