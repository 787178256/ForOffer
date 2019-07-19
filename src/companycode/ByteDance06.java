package companycode;

import java.util.Stack;

/**
 * Created by kimvra on 2019-07-19
 * 在O(1)时间复杂度找到当前栈的最大值
 */
public class ByteDance06 {

}
class MaxStack {
    private Stack<Integer> stack;

    private Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int num) {
        stack.push(num);
        if (maxStack.isEmpty() || maxStack.peek() < num) {
            maxStack.push(num);
        }
    }

    public int pop() {
        if (!stack.isEmpty()) {
            if (maxStack.peek() == stack.peek()) {
                maxStack.pop();
                return stack.pop();
            }
        }
        return -1;
    }

    public int getMax() {
        return maxStack.peek();
    }
}