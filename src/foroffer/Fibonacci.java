package foroffer;

/**
 * Created by kimvra on 2019-03-03
 */
public class Fibonacci {
    public int solution(int n) {
        int[] num = new int[40];
        num[0] = 0;
        num[1] = 1;
        num[2] = 1;
        int i = 3;
        for (; i <= n; i++) {
            num[i] = num[i-1] + num[i-2];
        }
        return num[n];
    }
}
