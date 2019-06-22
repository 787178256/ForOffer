package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kimvra on 2019-06-22
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 */
public class _0128_Longest_Consecutive {
    private int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int maxLen = Integer.MIN_VALUE;
        for (int i : nums) {
            int curLen = 1;
            if (!set.contains(i-1)) {
                while (set.contains(i+1)) {
                    curLen++;
                    i++;
                }
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }

    @Test
    public void test() {
        Assert.assertEquals(longestConsecutive(new int[]{100,4,200,1,3,2}), 4);
    }
}
