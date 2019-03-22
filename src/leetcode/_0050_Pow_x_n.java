package leetcode;

/**
 * Created by kimvra on 2019-03-13
 */
public class _0050_Pow_x_n {
    public double myPow(double x, int n) {
        if (n < 0) {
            return func(1 / x, -n);
        }
        return func(x, n);
    }

    private double func(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double d = func(x, n >>> 1);
        if (n % 2 == 0) {
            return d * d;
        }
        return d * d * x;
    }
}
