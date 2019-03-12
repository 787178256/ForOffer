package foroffer;

import java.util.Stack;

/**
 * Created by kimvra on 2019-03-10
 */
public class MinStack {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int num) {
        dataStack.push(num);
        minStack.push(minStack.isEmpty() ? num : Math.min(num, minStack.peek()));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return  dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
