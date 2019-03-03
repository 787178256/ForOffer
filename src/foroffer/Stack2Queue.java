package foroffer;

import java.util.Stack;

/**
 * Created by kimvra on 2019-03-02
 */
public class Stack2Queue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public void pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

}
