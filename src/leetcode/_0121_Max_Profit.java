package leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kimvra on 2019-06-21
 */
public class _0121_Max_Profit {

    private int maxProfit(int[] prices) {
        int len = prices.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len && prices[j] > prices[i]; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return Math.max(max, 0);
    }


    @Test
    public void test() {
        Assert.assertEquals(maxProfit(new int[]{7,1,3,6,4}), 5);
        Assert.assertEquals(maxProfit(new int[]{7,6,4,3,1}), 0);
    }
}
