package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kimvra on 2019-07-11
 */
public class Byte_ThreeSum {
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len - 1];
        int min = nums[0];
        if (max < 0 || min > 0) {
            return res;
        }
        for (int i = 0; i < len - 2;) {
            if (nums[i] > 0) {
                break;
            }
            if (i + 2 * max < 0) {
                while (nums[i] == nums[++i] && i < len-2);
                continue;
            }
            int left = i + 1, right = len -1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (nums[left] == nums[++left] && left < right);
                    while (nums[right] == nums[--right] && left < right);
                } else if (sum > 0) {
                    while (nums[right] == nums[--right] && left < right);
                } else {
                    while (nums[left] == nums[++left] && left < right);
                }
            }
            while (nums[i] == nums[++i] && i < len - 2);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numes = new int[]{-1,0,1,2,-1,-4};
        threeSum(numes);
    }
}
