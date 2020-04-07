package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by kimvra on 2020/4/7
 */
public class _0150_Eval_RPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second + first);
                    break;
                }
                case "-": {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second - first);
                    break;
                }
                case "*": {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second * first);
                    break;
                }
                case "/": {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second / first);
                    break;
                }
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }

    @Test
    public void test() {
        String[] token = {"10","16","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(token));
    }
}
