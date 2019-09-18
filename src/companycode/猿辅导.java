package companycode;

import org.junit.Test;

import java.util.*;

/**
 * Created by kimvra on 2019-09-18
 * 找出来数组中每个元素后边第一个比它大的值
 */
public class 猿辅导 {
    private void solution(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] >= nums[i]) {
                stack.add(i);
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int lastIndex = stack.pop();
                res[lastIndex] = nums[i];
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void test() {
        int[] nums = new int[]{4,3,2,1};
        solution(nums);
    }
}
