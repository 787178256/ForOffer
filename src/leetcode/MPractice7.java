package leetcode;

/**
 * Created by kimvra on 2019-03-01
 */
public class MPractice7 {
    public static int reverse(int x) {
        boolean flag = true;
        if (x < 0) {
            x = -x;
            flag = false;//表示负数
        }
        String s = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder(s);
        s = stringBuilder.reverse().toString();
        if (s.charAt(0) == '0') {
            s = s.substring(1);
        }
        if (!flag) {
            s = "-" + s;
        }
        return Integer.valueOf(s);
    }

    public static int reverse1(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) res;
        }
    }
    public static void main(String[] args) {
        System.out.println(reverse1(123));
        System.out.println(reverse1(-123));
        System.out.println(reverse1(120));
    }
}
