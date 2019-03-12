package leetcode;

import java.util.Stack;

/**
 * Created by kimvra on 2019-03-10
 */
public class MyQueue {

    private Stack<Integer> in = new Stack<>();

    private Stack<Integer> out = new Stack<>();

    public MyQueue() {
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }


    public int peek() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }
}
