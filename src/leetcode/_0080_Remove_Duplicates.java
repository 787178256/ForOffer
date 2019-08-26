package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by kimvra on 2019-08-26
 * [1,1,1,2,2,3]--->[1,1,2,2,3],输出数组长度5
 */
public class _0080_Remove_Duplicates {
    private int removeDuplicates(int[] nums) {
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                if (count < 2) {
                    map.put(nums[i], count + 1);
                    nums[index++] = nums[i];
                }
            } else {
                map.put(nums[i], 1);
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    @Test
    public void test() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
