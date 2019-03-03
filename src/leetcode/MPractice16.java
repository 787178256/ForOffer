package leetcode;

import java.util.Arrays;

/**
 * Created by kimvra on 2019-03-02
 */
public class MPractice16 {
    public static int threeSum(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int minRes = Integer.MAX_VALUE, minSum = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    int res = sum - target;
                    while (nums[i] + nums[left] + nums[--right] > target && right > left);
                    if (right == left) {
                        sum = nums[i] + nums[left] + nums[right + 1];
                        res = sum - target;
                        if (res < minRes) {
                            minRes = res;
                            minSum = sum;
                        }
                    } else {
                        sum = nums[i] + nums[left] + nums[right];
                        if (sum == target) {
                            return target;
                        } else {
                            int sum1 = nums[i] + nums[left] + nums[right+1];
                            if (sum1 - target < res) {
                                res = sum1 - target;
                                if (res < target - sum) {
                                    minRes = res;
                                    minSum = sum1;
                                }
                            }
                            if (target - sum < res) {
                                res = target - sum;
                                if (res < sum1 - target) {
                                    minRes = res;
                                    minSum = sum;
                                }
                            }
                        }
                    }
                } else {
                    int res = target - sum;
                    while (nums[i] + nums[++left] + nums[right] < target && right > left);
                    if (right == left) {
                        sum = nums[i] + nums[left - 1] + nums[right];
                        res = target - sum;
                        if (res < minRes) {
                            minRes = res;
                            minSum = sum;
                        }
                    } else {
                        sum = nums[i] + nums[left] + nums[right];
                        if (sum == target) {
                            return target;
                        } else {
                            int sum1 = nums[i] + nums[left-1] + nums[right];
                            if (target - sum1 < res) {
                                res = target - sum1;
                                if (res < sum - target) {
                                    minRes = res;
                                    minSum = sum1;
                                }
                            }
                            if (sum - target < res) {
                                res = sum - target;
                                if (res < target - sum1) {
                                    minRes = res;
                                    minSum = sum;
                                }
                            }
                        }
                    }
                }
            }
        }
        return minSum;
    }

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
        System.out.println(threeSum(nums, target));
    }
}
