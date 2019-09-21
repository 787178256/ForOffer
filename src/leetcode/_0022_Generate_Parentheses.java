package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-03-05
 */
public class _0022_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        solution(list, "",n, 0);
        return list;
    }

    private void func(List<String> list, String string, int rightNeed, int leftRest) {
        if (rightNeed == 0 && leftRest == 0) {
            list.add(string);
            return;
        }

        if (rightNeed > 0) {
            func(list, string + ")", rightNeed - 1, leftRest);
        }
        if (leftRest > 0) {
            func(list, string + "(", rightNeed + 1, leftRest - 1);
        }
    }

    private void solution(List<String> list, String s, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }
        if (left > 0) {
            solution(list, s + "(", left - 1, right + 1);
        }
        if (right > 0) {
            solution(list, s + ")", left, right - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
    }
}
