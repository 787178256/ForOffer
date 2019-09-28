package pat;

import org.junit.Test;

/**
 * Created by kimvra on 2019-09-28
 */
public class B1001 {
    private int solution(int n) {
        int step = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (3 * n + 1) / 2;
            }
            step++;
        }
        return step;
    }

    @Test
    public void test() {
        System.out.println(solution(3));
    }
}
