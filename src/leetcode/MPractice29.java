package leetcode;

/**
 * Created by kimvra on 2019-03-06
 */
public class MPractice29 {
    private static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dvd = (long) Math.abs(dividend);
        long div = (long) Math.abs(divisor);
        int res = 0;
        while (dvd >= div) {
            long temp = div, multiple = 1;
            while (dvd >= temp << 1) {
                temp = temp << 1;
                multiple = multiple << 1;
            }
            dvd = dvd - temp;
            res += multiple;
        }
        return (dividend < 0) ^ (divisor < 0) ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(divide(2147483647, -1));
    }
}
