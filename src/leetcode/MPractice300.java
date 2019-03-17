package leetcode;

import java.util.Arrays;

/**
 * Created by kimvra on 2019-03-17
 */
public class MPractice300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n==0) {
            return 0;
        }

        int res = 1;
        int[] memo = new int[n];

        Arrays.fill(memo, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    memo[i] = max(memo[i] , memo[j]+1);
            }
        }

        for(int i = 0;i<n;i++){
            res = max(memo[i],res);
        }
        return res;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
