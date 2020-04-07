package leetcode;

import org.junit.Test;

/**
 * Created by kimvra on 2020/4/7
 */
public class _0151_Reverse_Words {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].trim().isEmpty()) {
                continue;
            }
            stringBuilder.append(strings[i]).append(" ");
        }
        if (!s.trim().isEmpty()) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        System.out.println(reverseWords("   "));
    }
}
