package companycode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kimvra on 2019-09-20
 */
public class Tencent10 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,9,4,7};
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        solution(nums, sum / 2, nums.length / 2);
    }


    private static void solution(int[] nums, int maxValue, int k) {
        int[][] dp = new int[k + 1][maxValue + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= maxValue; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    for (int num : nums) {
                        if (j < num) {
                            continue;
                        }
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - num] + num);
                    }
                }
            }
        }
        System.out.println(dp[k][maxValue]);
    }

    private static void func(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, nums.length / 2, 0, 0, sum / 2, list);
        Collections.sort(list, (x, y) -> (y - x));
        System.out.print(list.get(0) + " ");
        System.out.print(sum - list.get(0));
    }

    private static void dfs(int[] nums, int count, int c, int sum, int index, int maxSum, List<Integer> list) {
        if (count == c && sum <= maxSum) {
            list.add(sum);
            return;
        }
        if (count > c) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            sum += nums[index];
            dfs(nums, count + 1, c, sum, i + 1, maxSum, list);
            sum -= nums[index];
        }
    }
}
