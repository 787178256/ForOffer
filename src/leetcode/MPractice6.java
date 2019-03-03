package leetcode;

/**
 * Created by kimvra on 2019-03-01
 */
public class MPractice6 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        int cycle = 2 * (numRows - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < len; j = j + cycle) {
            stringBuilder.append(chars[j]);
        }
        for (int i = 1; i < numRows - 1; i++) {
            int step = 2 * i;
            for (int j = i; j < len; j += step) {
                stringBuilder.append(chars[j]);
                step = cycle - step;
            }
        }
        for (int j = numRows - 1; j < len; j += cycle) {
            stringBuilder.append(chars[j]);
        }
        return stringBuilder.toString();
    }
}
