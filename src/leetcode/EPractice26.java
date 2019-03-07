package leetcode;

import java.util.HashMap;

/**
 * Created by kimvra on 2019-03-06
 */
public class EPractice26 {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        return map.size();
    }

    public static int removeDuplicates1(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int tail = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
