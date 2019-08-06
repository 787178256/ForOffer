package leetcode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-08-06
 */
public class _0137_Single_NumberII {
    private int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }

    @Test
    public void test() {
        int[] nums = {2,2,2,3};
        System.out.println(singleNumber(nums));
    }
}
