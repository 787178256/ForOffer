package companycode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-09-17
 */
public class FindMissedNum {
    private int func(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sum1 = (len + 1 + 1) * (len + 1) / 2;
        return sum1 - sum;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,5,6};
        System.out.println(func(nums));
    }
}
