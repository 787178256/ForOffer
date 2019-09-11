package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by kimvra on 2019-09-11
 */
public class _0907_Sum_Sub_Array {
    private int sumSubArray(int[] A) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int a : A) {
            list.add(a);
        }
        list.add(Integer.MIN_VALUE);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (stack.isEmpty() || list.get(stack.peek()) <= list.get(i)) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && list.get(stack.peek()) > list.get(i)) {
                int lastIndex = stack.pop();
                sum += list.get(lastIndex) * (stack.isEmpty() ? (i - lastIndex) * (lastIndex + 1) : (i - lastIndex) * (lastIndex - stack.peek()));
            }
            stack.push(i);
        }
        return sum;
    }

    @Test
    public void test() {
        int[] A = {3,1,2,4};
        System.out.println(sumSubArray(A));
    }
}
