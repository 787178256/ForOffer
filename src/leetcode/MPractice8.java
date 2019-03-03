package leetcode;

/**
 * Created by kimvra on 2019-03-01
 */
public class MPractice8 {
    public static int myAtoi(String str) {
        int len = str.length();
        int result = 0;
        int sign = 1;
        int i = 0;
        while (i < len && str.charAt(i) == ' ') {
            ++i;
        }
        if (i >= len) {
            return 0;
        }
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        for (; i < len; i++) {
            int temp = str.charAt(i) - '0';
            if (temp > 9 || temp < 0) {
                break;
            }
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (sign == 1 && temp > 7 || sign == -1 && temp > 8))) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + temp;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        /*System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));*/
        //System.out.println(myAtoi("9223372036854775808"));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
