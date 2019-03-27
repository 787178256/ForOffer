package pat;

/**
 * Created by kimvra on 2019-03-25
 */
public class GCD {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private int lcm(int a, int b) {
        int d = gcd(a, b);
        return a / d * b;
    }
}
