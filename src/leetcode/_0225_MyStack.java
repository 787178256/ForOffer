package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by kimvra on 2019-09-03
 */
public class _0225_MyStack {

    Deque<Integer> queue;

    /** Initialize your data structure here. */
    public _0225_MyStack() {
        queue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return queue.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
