package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-03-05
 */
public class MPractice22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        func(list, "",0, n);
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
}
