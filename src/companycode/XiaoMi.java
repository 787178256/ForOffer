package companycode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-09-06
 * 1(2(3,4(,5)),6(7,))
 */
public class XiaoMi {
    private void func(String string) {
        if ("".equals(string)) {
            return;
        }
        String s = string.substring(2, string.length() - 1);
        String leftStr = "";
        int i = 0;
        if (s.charAt(1) == ',') {
            leftStr = s.substring(0, 1);
        } else {
            int left = 0;
            for (; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                }
                if (s.charAt(i) == ')') {
                    left--;
                }
                if (left == 0 && i != 0) {
                    leftStr = s.substring(0, i + 1);
                    break;
                }
            }
        }
        func(leftStr);
        System.out.print(string.charAt(0));

        func(s.substring(i + 2));
    }

    @Test
    public void test() {
        func("1(2(3,4(,5)),6(7,))");
    }
}
