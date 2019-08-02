package leetcode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-08-02
 * dfs超时
 */
public class _0045_JumpII {

    private int jump(int[] nums) {
        int end = 0, maxPosition = 0, steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }



    private int min = Integer.MAX_VALUE;
    private int jumpDFS(int[] nums) {
        dfs(0, nums, 0);
        return min;
    }

    private void dfs(int index, int[] nums, int count) {
        if (index == nums.length - 1) {
            min = Math.min(min, count);
            return;
        }
        int pathCount = nums[index];
        for (int i = 1; i <= pathCount; i++) {
            if (i + index < nums.length) {
                dfs(i + index, nums, count + 1);
            } else {
                break;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
